package com.ecommerce.dao;

import java.sql.*;
import java.util.*;
import com.ecommerce.model.Category;

public class CategoryDAO {

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM categories");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
