package com.ecommerce.dao;

import java.sql.*;

public class UserDAO {

    public void save(String email, String password) {
        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(email, password, role) VALUES (?, ?, ?)"
            );
            ps.setString(1, email);
            ps.setString(2, password);   // hashing later
            ps.setString(3, "USER");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String email, String password) {
        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAdmin(String email) {
        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT role FROM users WHERE email=?"
            );
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "admin".equals(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
