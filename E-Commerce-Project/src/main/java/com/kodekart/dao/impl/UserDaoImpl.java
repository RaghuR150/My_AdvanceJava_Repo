package com.kodekart.dao.impl;

import com.kodekart.dao.UserDao;
import com.kodekart.model.User;
import com.kodekart.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean emailExists(String email) {
        String sql = "SELECT 1 FROM users WHERE email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking email existence", e);
        }
    }

    @Override
    public int save(User u) {
        String sql = "INSERT INTO users(name,email,phone,password,role) VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getPassword()); // already hashed before saving
            ps.setString(5, u.getRole());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by email", e);
        }
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String rawPassword) {
        User u = findByEmail(email);
        if (u == null) return null;
        return BCrypt.checkpw(rawPassword, u.getPassword()) ? u : null;
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by ID", e);
        }
        return null;
    }

    @Override
    public void ensureAdminSeeded(String adminEmail, String adminPlainPassword) {
        User existing = findByEmail(adminEmail);
        if (existing == null) {
            String hash = BCrypt.hashpw(adminPlainPassword, BCrypt.gensalt(12));
            User admin = new User("Admin", adminEmail, "9999999999", hash, "ADMIN");
            save(admin);
            System.out.println(" Default admin created: " + adminEmail);
        } else if (!existing.getPassword().startsWith("$2a$")) {
            // auto-upgrade old plain-text admin password if found
            String hash = BCrypt.hashpw(adminPlainPassword, BCrypt.gensalt(12));
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement("UPDATE users SET password=? WHERE id=?")) {
                ps.setString(1, hash);
                ps.setInt(2, existing.getId());
                ps.executeUpdate();
                System.out.println("Admin password upgraded to secure hash.");
            } catch (SQLException e) {
                throw new RuntimeException("Error upgrading admin password", e);
            }
        }
    }

    private User map(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setPassword(rs.getString("password"));
        u.setRole(rs.getString("role"));
        return u;
    }
}
