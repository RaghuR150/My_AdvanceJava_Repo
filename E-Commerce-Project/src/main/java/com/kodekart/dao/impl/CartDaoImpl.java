package com.kodekart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kodekart.dao.CartDao;
import com.kodekart.model.CartItem;
import com.kodekart.util.DBConnection;

public class CartDaoImpl implements CartDao {

    // ---------- ADD TO CART ----------
    @Override
    public int addToCart(int userId, int productId, int qty) {
        CartItem existing = findByUserAndProduct(userId, productId);
        if (existing != null) {
            return updateQty(userId, productId, existing.getQuantity() + qty);
        }
        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection()) {
            return addToCart(userId, productId, qty, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Overloaded version (for shared connection)
    public int addToCart(int userId, int productId, int qty, Connection con) throws SQLException {
        CartItem existing = findByUserAndProduct(userId, productId, con);
        if (existing != null) {
            return updateQty(userId, productId, existing.getQuantity() + qty, con);
        }
        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, qty);
            return ps.executeUpdate();
        }
    }

    // ---------- UPDATE QUANTITY ----------
    @Override
    public int updateQty(int userId, int productId, int qty) {
        try (Connection con = DBConnection.getConnection()) {
            return updateQty(userId, productId, qty, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateQty(int userId, int productId, int qty, Connection con) throws SQLException {
        String sql = "UPDATE cart SET quantity=? WHERE user_id=? AND product_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, userId);
            ps.setInt(3, productId);
            return ps.executeUpdate();
        }
    }

    // ---------- REMOVE FROM CART ----------
    @Override
    public int removeFromCart(int cartItemId, int userId) {
        try (Connection con = DBConnection.getConnection()) {
            return removeFromCart(cartItemId, userId, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int removeFromCart(int cartItemId, int userId, Connection con) throws SQLException {
        String sql = "DELETE FROM cart WHERE id=? AND user_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cartItemId);
            ps.setInt(2, userId);
            return ps.executeUpdate();
        }
    }

    // ---------- GET USER CART ----------
    @Override
    public List<CartItem> getUserCart(int userId) {
        String sql = "SELECT * FROM cart WHERE user_id=? ORDER BY id";
        List<CartItem> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // ---------- CLEAR CART ----------
    @Override
    public int clearCart(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            return clearCart(userId, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Overloaded version for shared connection
    public int clearCart(int userId, Connection con) throws SQLException {
        String sql = "DELETE FROM cart WHERE user_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            return ps.executeUpdate();
        }
    }

    // ---------- FIND BY USER AND PRODUCT ----------
    @Override
    public CartItem findByUserAndProduct(int userId, int productId) {
        try (Connection con = DBConnection.getConnection()) {
            return findByUserAndProduct(userId, productId, con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Overloaded version for shared connection
    public CartItem findByUserAndProduct(int userId, int productId, Connection con) throws SQLException {
        String sql = "SELECT * FROM cart WHERE user_id=? AND product_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    // ---------- MAP HELPER ----------
    private CartItem map(ResultSet rs) throws SQLException {
        CartItem c = new CartItem();
        c.setId(rs.getInt("id"));
        c.setUserId(rs.getInt("user_id"));
        c.setProductId(rs.getInt("product_id"));
        c.setQuantity(rs.getInt("quantity"));
        return c;
    }
}
