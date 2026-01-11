package com.ecommerce.controller;

import java.io.IOException;

import com.ecommerce.dao.CategoryDAO;

import com.ecommerce.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String search = req.getParameter("q");
        String cat = req.getParameter("cat");

        ProductService ps = new ProductService();
        CategoryDAO cd = new CategoryDAO();

        // categories (always)
        req.setAttribute("categories", cd.getAllCategories());

        if (search != null && !search.isEmpty()) {
            req.setAttribute("products", ps.searchProducts(search));
        } 
        else if (cat != null) {
            req.setAttribute("products", ps.getByCategory(Integer.parseInt(cat)));
        } 
        else {
            req.setAttribute("products", ps.getRandomProducts()); // homepage
        }

        req.getRequestDispatcher("/WEB-INF/views/products.jsp")
           .forward(req, res);
    }
}

