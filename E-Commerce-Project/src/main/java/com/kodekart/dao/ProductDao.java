package com.kodekart.dao;

import com.kodekart.model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

	// --- Normal methods (standalone operations) ---
	int save(Product p);

	int update(Product p);

	int delete(int id);

	Product findById(int id);

	List<Product> findAll();

	List<Product> searchByNameOrCategory(String keyword);

	int reduceStock(int productId, int qty);

	// --- Overloaded methods for shared Connection (used in transactions) ---
	Product findById(int id, Connection con) throws SQLException;

	int reduceStock(int productId, int qty, Connection con) throws SQLException;
}
