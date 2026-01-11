package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

public class ProductService {

    private ProductDAO dao = new ProductDAO();

    // all products
    public List<Product> getProducts() {
        return dao.getAllProducts();
    }

    // search products
    public List<Product> searchProducts(String keyword) {
        return dao.search(keyword);
    }

    // 🔥 get random products (HOME PAGE)
    public List<Product> getRandomProducts() {
        return dao.getRandomProducts();
    }

    // 🔥 get products by category
    public List<Product> getByCategory(int categoryId) {
        return dao.getByCategory(categoryId);
    }
}
