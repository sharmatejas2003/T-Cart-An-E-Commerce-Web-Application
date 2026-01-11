package com.ecommerce.controller;

import java.io.IOException;
import com.ecommerce.dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();
        dao.save(email, password);

        // auto-login after registration
        HttpSession session = req.getSession();
        session.setAttribute("user", email);

        res.sendRedirect(req.getContextPath() + "/products");
    }
}
