package com.kodekart.service;

import com.kodekart.dao.*;
import com.kodekart.dao.impl.*;
import com.kodekart.model.*;
import com.kodekart.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final CartDao cartDao = new CartDaoImpl();
    private final ProductDao productDao = new ProductDaoImpl();
    private final OrderDao orderDao = new OrderDaoImpl();

    public boolean placeOrder(int userId) {
        int attempts = 0;

        while (attempts < 3) {
            attempts++;
            try (Connection con = DBConnection.getConnection()) {

                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                // Get user cart
                List<CartItem> cart = cartDao.getUserCart(userId);
                if (cart.isEmpty()) {
                    System.out.println(" Your cart is empty.");
                    return false;
                }

                List<OrderItem> items = new ArrayList<>();
                BigDecimal total = BigDecimal.ZERO;

                // Validate products and prepare order items
                for (CartItem ci : cart) {
                    Product p = productDao.findById(ci.getProductId(), con);
                    if (p == null) {
                        System.out.println(" Product missing: " + ci.getProductId());
                        con.rollback();
                        return false;
                    }
                    if (p.getQuantity() < ci.getQuantity()) {
                        System.out.println(" Insufficient stock for: " + p.getName());
                        con.rollback();
                        return false;
                    }

                    BigDecimal line = p.getPrice().multiply(BigDecimal.valueOf(ci.getQuantity()));
                    total = total.add(line);

                    OrderItem oi = new OrderItem();
                    oi.setProductId(p.getId());
                    oi.setQuantity(ci.getQuantity());
                    oi.setPrice(p.getPrice());
                    items.add(oi);
                }

                try {
                    // Create order record
                    Order order = new Order();
                    order.setUserId(userId);
                    order.setTotalAmount(total);
                    int orderId = orderDao.createOrder(con, order);
                    if (orderId == 0) throw new SQLException("Order ID not generated.");

                    // Save order items
                    orderDao.addOrderItems(con, orderId, items);

                    // Update stock for each product (shared connection)
                    for (CartItem ci : cart) {
                        int updated = productDao.reduceStock(ci.getProductId(), ci.getQuantity(), con);
                        if (updated == 0) throw new SQLException("Stock update failed for product ID: " + ci.getProductId());
                    }

                    // Clear user's cart (shared connection)
                    cartDao.clearCart(userId, con);

                    con.commit();
                    System.out.println(" Order placed successfully! Order ID: " + orderId + " | Total: ₹" + total);
                    return true;

                } catch (SQLException e) {
                    con.rollback();
                    String msg = e.getMessage().toLowerCase();
                    if (msg.contains("lock wait timeout") || msg.contains("deadlock")) {
                        System.out.println(" Lock conflict — retrying order (" + attempts + "/3)...");
                        Thread.sleep(100);
                        continue;
                    }
                    System.out.println(" Order failed: " + e.getMessage());
                    return false;
                } finally {
                    con.setAutoCommit(true);
                }

            } catch (SQLException e) {
                System.out.println(" Database error: " + e.getMessage());
                return false;
            } catch (InterruptedException ignored) {
            }
        }

        System.out.println("Order could not be placed after 3 attempts due to lock contention.");
        return false;
    }

    public void viewUserOrders(int userId) {
        List<Order> list = orderDao.getOrdersByUser(userId);
        if (list.isEmpty()) {
            System.out.println("(no orders)");
            return;
        }
        System.out.println("\n-- Your Orders --");
        list.forEach(o ->
                System.out.printf("OrderID:%d | Date:%s | Total:%s%n",
                        o.getId(), o.getOrderDate(), o.getTotalAmount()));
    }

    public void viewAllOrders() {
        List<Order> list = orderDao.getAllOrders();
        if (list.isEmpty()) {
            System.out.println("(no orders)");
            return;
        }
        System.out.println("\n-- All Orders --");
        list.forEach(o ->
                System.out.printf("OrderID:%d | UserID:%d | Date:%s | Total:%s%n",
                        o.getId(), o.getUserId(), o.getOrderDate(), o.getTotalAmount()));
    }
}
