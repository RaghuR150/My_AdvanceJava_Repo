package com.kodekart.service;

import com.kodekart.dao.ProductDao;
import com.kodekart.dao.impl.ProductDaoImpl;
import com.kodekart.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final ProductDao productDao = new ProductDaoImpl();
    private final Scanner in = new Scanner(System.in);

    public void add() {
        System.out.println("\n-- Add Product --");
        System.out.print("Name: ");
        String name = in.nextLine().trim();
        System.out.print("Category: ");
        String category = in.nextLine().trim();
        System.out.print("Price: ");
        BigDecimal price = new BigDecimal(in.nextLine().trim());
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(in.nextLine());
        System.out.print("Description: ");
        String desc = in.nextLine().trim();

        Product p = new Product(name, category, price, qty, desc);
        int id = productDao.save(p);
        System.out.println(id > 0 ? "Product added with ID: " + id : "Failed to add product.");
    }

    public void update() {
        System.out.println("\n-- Update Product --");
        System.out.print("Product ID: ");
        int id = Integer.parseInt(in.nextLine());
        Product p = productDao.findById(id);
        if (p == null) { System.out.println("Not found."); return; }

        System.out.print("Name (" + p.getName() + "): ");
        String name = readOrDefault(p.getName());
        System.out.print("Category (" + p.getCategory() + "): ");
        String cat = readOrDefault(p.getCategory());
        System.out.print("Price (" + p.getPrice() + "): ");
        String priceStr = in.nextLine().trim();
        System.out.print("Quantity (" + p.getQuantity() + "): ");
        String qtyStr = in.nextLine().trim();
        System.out.print("Description (" + p.getDescription() + "): ");
        String desc = readOrDefault(p.getDescription());

        p.setName(name);
        p.setCategory(cat);
        if (!priceStr.isEmpty()) p.setPrice(new BigDecimal(priceStr));
        if (!qtyStr.isEmpty()) p.setQuantity(Integer.parseInt(qtyStr));
        p.setDescription(desc);

        int rows = productDao.update(p);
        System.out.println(rows > 0 ? "Updated." : "Update failed.");
    }

    public void delete() {
        System.out.println("\n-- Delete Product --");
        System.out.print("Product ID: ");
        int id = Integer.parseInt(in.nextLine());
        int rows = productDao.delete(id);
        System.out.println(rows > 0 ? "Deleted." : "Delete failed.");
    }

    public void viewAll() {
        System.out.println("\n-- All Products --");
        List<Product> list = productDao.findAll();
        if (list.isEmpty()) { System.out.println("(no products)"); return; }
        list.forEach(this::printProduct);
    }

    public void search() {
        System.out.println("\n-- Search Products --");
        System.out.print("Keyword (name/category): ");
        String k = in.nextLine().trim();
        List<Product> list = productDao.searchByNameOrCategory(k);
        if (list.isEmpty()) { System.out.println("(no matches)"); return; }
        list.forEach(this::printProduct);
    }

    private void printProduct(Product p) {
        System.out.printf("ID:%d | %s | Cat:%s | Price:%s | Qty:%d | %s%n",
                p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getQuantity(), p.getDescription());
    }

    private String readOrDefault(String def) {
        String s = in.nextLine().trim();
        return s.isEmpty() ? def : s;
    }
}
