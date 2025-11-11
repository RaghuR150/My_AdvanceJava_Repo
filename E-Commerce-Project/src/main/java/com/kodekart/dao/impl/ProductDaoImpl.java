package com.kodekart.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kodekart.dao.ProductDao;
import com.kodekart.model.Product;
import com.kodekart.util.DBConnection;

public class ProductDaoImpl implements ProductDao {

    // ---------- SAVE ----------
    @Override
    public int save(Product p) {
        String sql = "INSERT INTO products(name,category,price,quantity,description) VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection()) {
            return save(p, con);
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    // Overloaded method for shared connection
    public int save(Product p, Connection con) throws SQLException {
        String sql = "INSERT INTO products(name,category,price,quantity,description) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setBigDecimal(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setString(5, p.getDescription());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    // ---------- UPDATE ----------
    @Override
    public int update(Product p) {
        String sql = "UPDATE products SET name=?, category=?, price=?, quantity=?, description=? WHERE id=?";
        try (Connection con = DBConnection.getConnection()) {
            return update(p, con);
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public int update(Product p, Connection con) throws SQLException {
        String sql = "UPDATE products SET name=?, category=?, price=?, quantity=?, description=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setBigDecimal(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getId());
            return ps.executeUpdate();
        }
    }

    // ---------- DELETE ----------
    @Override
    public int delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        try (Connection con = DBConnection.getConnection()) {
            return delete(id, con);
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public int delete(int id, Connection con) throws SQLException {
        String sql = "DELETE FROM products WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    // ---------- FIND BY ID ----------
    @Override
    public Product findById(int id) {
        try (Connection con = DBConnection.getConnection()) {
            return findById(id, con);
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public Product findById(int id, Connection con) throws SQLException {
        String sql = "SELECT * FROM products WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        }
        return null;
    }

    // ---------- FIND ALL ----------
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products ORDER BY id";
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) { throw new RuntimeException(e); }
        return list;
    }

    // ---------- SEARCH ----------
    @Override
    public List<Product> searchByNameOrCategory(String keyword) {
        String sql = "SELECT * FROM products WHERE name LIKE ? OR category LIKE ? ORDER BY id";
        List<Product> list = new ArrayList<>();
        String like = "%" + keyword + "%";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, like);
            ps.setString(2, like);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return list;
    }

    // ---------- REDUCE STOCK ----------
    @Override
    public int reduceStock(int productId, int qty) {
        try (Connection con = DBConnection.getConnection()) {
            return reduceStock(productId, qty, con);
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    // Overloaded version using shared connection (used in transactions)
    public int reduceStock(int productId, int qty, Connection con) throws SQLException {
        String sql = "UPDATE products SET quantity = quantity - ? WHERE id = ? AND quantity >= ? LIMIT 1";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, qty);
            ps.setInt(2, productId);
            ps.setInt(3, qty);
            return ps.executeUpdate();
        }
    }

    // ---------- MAP HELPER ----------
    private Product map(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setCategory(rs.getString("category"));
        p.setPrice(rs.getBigDecimal("price"));
        p.setQuantity(rs.getInt("quantity"));
        p.setDescription(rs.getString("description"));
        return p;
    }
}
