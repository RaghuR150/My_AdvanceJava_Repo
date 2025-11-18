package com.kodekart.main;

import com.kodekart.model.User;
import com.kodekart.service.*;

import java.util.Scanner;

public class KodeKartApp {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();

        // Ensure admin user exists (email: admin@kodekart.com / password: admin123)
        userService.seedAdminIfMissing();

        while (true) {
            System.out.println("\n=== KodeKart ===");
            System.out.println("1) Register  2) Login  3) Exit");
            System.out.print("Choose: ");
            String line = in.nextLine().trim();
            int ch = line.isEmpty() ? 0 : Integer.parseInt(line);
           
            if (ch == 1) userService.register();
            else if (ch == 2) {
                User u = userService.login();
                if (u == null) continue;
                if ("ADMIN".equalsIgnoreCase(u.getRole())) adminMenu(productService, orderService);
                else userMenu(u, productService, cartService, orderService);
            } else if (ch == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void userMenu(User u, ProductService ps, CartService cs, OrderService os) {
        while (true) {
            System.out.println("\n-- User Menu --");
            System.out.println("1) View Products");
            System.out.println("2) Search Product");
            System.out.println("3) Add to Cart");
            System.out.println("4) View Cart");
            System.out.println("5) Place Order");
            System.out.println("6) View Order History");
            System.out.println("7) Logout");
            System.out.print("Choose: ");
            int ch = Integer.parseInt(in.nextLine());
            switch (ch) {
                case 1 -> ps.viewAll();
                case 2 -> ps.search();
                case 3 -> cs.addToCart(u.getId());
                case 4 -> cs.viewCart(u.getId());
                case 5 -> os.placeOrder(u.getId());
                case 6 -> os.viewUserOrders(u.getId());
                case 7 -> { return; }
                default -> System.out.println("Invalid.");
            }
        }
    }

    private static void adminMenu(ProductService ps, OrderService os) {
        while (true) {
            System.out.println("\n-- Admin Menu --");
            System.out.println("1) Add Product");
            System.out.println("2) Update Product");
            System.out.println("3) Delete Product");
            System.out.println("4) View All Products");
            System.out.println("5) View All Orders");
            System.out.println("6) Logout");
            System.out.print("Choose: ");
            int ch = Integer.parseInt(in.nextLine());
            switch (ch) {
                case 1 -> ps.add();
                case 2 -> ps.update();
                case 3 -> ps.delete();
                case 4 -> ps.viewAll();
                case 5 -> os.viewAllOrders();
                case 6 -> { return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
