package com.kodekart.dao.impl;

import com.kodekart.dao.OrderDao;
import com.kodekart.model.Order;
import com.kodekart.model.OrderItem;
import com.kodekart.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    // ---------------- CREATE ORDER ----------------
    @Override
    public int createOrder(Connection con, Order order) {
        String sql = "INSERT INTO orders(user_id,total_amount) VALUES(?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setBigDecimal(2, order.getTotalAmount());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating order", e);
        }
    }

    // Overloaded method (optional, standalone use)
    public int createOrder(Order order) {
        try (Connection con = DBConnection.getConnection()) {
            return createOrder(con, order);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating order (standalone)", e);
        }
    }

    // ---------------- ADD ORDER ITEMS ----------------
    @Override
    public int addOrderItems(Connection con, int orderId, List<OrderItem> items) {
        String sql = "INSERT INTO order_items(order_id,product_id,quantity,price) VALUES(?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            int count = 0;
            for (OrderItem it : items) {
                ps.setInt(1, orderId);
                ps.setInt(2, it.getProductId());
                ps.setInt(3, it.getQuantity());
                ps.setBigDecimal(4, it.getPrice());
                count += ps.executeUpdate();
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding order items", e);
        }
    }

    // Overloaded version for standalone use
    public int addOrderItems(int orderId, List<OrderItem> items) {
        try (Connection con = DBConnection.getConnection()) {
            return addOrderItems(con, orderId, items);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding order items (standalone)", e);
        }
    }

    // ---------------- GET ORDERS BY USER ----------------
    @Override
    public List<Order> getOrdersByUser(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id=? ORDER BY id DESC";
        List<Order> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching user orders", e);
        }
        return list;
    }

    // ---------------- GET ALL ORDERS ----------------
    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders ORDER BY id DESC";
        List<Order> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all orders", e);
        }
        return list;
    }

    // ---------------- MAP RESULTSET ----------------
    private Order map(ResultSet rs) throws SQLException {
        Order o = new Order();
        o.setId(rs.getInt("id"));
        o.setUserId(rs.getInt("user_id"));
        o.setOrderDate(rs.getTimestamp("order_date"));
        o.setTotalAmount(rs.getBigDecimal("total_amount"));
        return o;
    }
}
