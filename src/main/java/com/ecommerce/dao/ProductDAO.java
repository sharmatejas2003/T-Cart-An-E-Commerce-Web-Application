package com.ecommerce.dao;

import java.sql.*;
import java.util.*;
import com.ecommerce.model.Product;

public class ProductDAO {
	
	
	
    //Get List of All the Products
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setDiscount(rs.getInt("discount"));
                
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    // Search particular Order by the ID
    public Product findById(int id) {
        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(id);
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT p.* FROM products p JOIN  categories c ON p.category_id = c.id WHERE p.name LIKE ? OR p.description LIKE ? or c.name LIKE ? ");
            String k = "%" + keyword + "%";
            ps.setString(1,k);
            ps.setString(2,k);
            ps.setString(3,k);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setDiscount(rs.getInt("discount"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    public List<Product> getRandomProducts() {
        List<Product> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM products ORDER BY RAND()");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setDiscount(rs.getInt("discount"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    public List<Product> getByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM products WHERE category_id=?");
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setDiscount(rs.getInt("discount"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    


}
