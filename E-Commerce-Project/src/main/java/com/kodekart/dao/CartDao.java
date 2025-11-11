package com.kodekart.dao;

import com.kodekart.model.CartItem;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {

	// --- Standard methods ---
	int addToCart(int userId, int productId, int qty);

	int updateQty(int userId, int productId, int qty);

	int removeFromCart(int cartItemId, int userId);

	List<CartItem> getUserCart(int userId);

	int clearCart(int userId);

	CartItem findByUserAndProduct(int userId, int productId);

	// --- Overloaded methods for shared Connection (used in transactions) ---
	int clearCart(int userId, Connection con) throws SQLException;

	CartItem findByUserAndProduct(int userId, int productId, Connection con) throws SQLException;
}
