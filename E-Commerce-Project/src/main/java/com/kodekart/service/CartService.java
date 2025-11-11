package com.kodekart.service;

import com.kodekart.dao.CartDao;
import com.kodekart.dao.ProductDao;
import com.kodekart.dao.impl.CartDaoImpl;
import com.kodekart.dao.impl.ProductDaoImpl;
import com.kodekart.model.CartItem;
import com.kodekart.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CartService {
    private final CartDao cartDao = new CartDaoImpl();
    private final ProductDao productDao = new ProductDaoImpl();
    private final Scanner in = new Scanner(System.in);

    public void addToCart(int userId) {
        System.out.println("\n-- Add to Cart --");
        System.out.print("Product ID: ");
        int pid = Integer.parseInt(in.nextLine());
        System.out.print("Qty: ");
        int qty = Integer.parseInt(in.nextLine());

        Product p = productDao.findById(pid);
        if (p == null) { System.out.println("Product not found."); return; }
        if (qty <= 0) { System.out.println("Invalid qty."); return; }

        int rows = cartDao.addToCart(userId, pid, qty);
        System.out.println(rows > 0 ? "Added to cart." : "Failed to add.");
    }

    public void viewCart(int userId) {
        System.out.println("\n-- Your Cart --");
        List<CartItem> items = cartDao.getUserCart(userId);
        if (items.isEmpty()) { System.out.println("(empty)"); return; }

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem c : items) {
            Product p = productDao.findById(c.getProductId());
            if (p == null) continue;
            BigDecimal line = p.getPrice().multiply(BigDecimal.valueOf(c.getQuantity()));
            total = total.add(line);
            System.out.printf("CartID:%d | ProdID:%d | %s | Qty:%d | Price:%s | Line:%s%n",
                    c.getId(), p.getId(), p.getName(), c.getQuantity(), p.getPrice(), line);
        }
        System.out.println("Cart Total: " + total);
        System.out.println("Options: 1) Remove item  2) Back");
        String ch = in.nextLine().trim();
        if ("1".equals(ch)) removeItem(userId);
    }

    private void removeItem(int userId) {
        System.out.print("Enter CartID to remove: ");
        int cid = Integer.parseInt(in.nextLine());
        int rows = cartDao.removeFromCart(cid, userId);
        System.out.println(rows > 0 ? "Removed." : "Remove failed.");
    }
}
