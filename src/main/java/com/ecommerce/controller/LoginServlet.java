package com.ecommerce.controller;

import java.io.IOException;

import com.ecommerce.dao.UserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();

        // validate user from database
        if (dao.validate(email, password)) {

            HttpSession session = req.getSession();
            session.setAttribute("user", email);

            // check role
            if (dao.isAdmin(email)) {
                session.setAttribute("admin", email);
                res.sendRedirect(req.getContextPath() + "/admin");
            } else {
                res.sendRedirect(req.getContextPath() + "/products");
            }

        } else {
            // invalid login → back to login page
            res.sendRedirect(req.getContextPath() + "/login-page");
        }
    }
}
