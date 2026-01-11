package com.ecommerce.controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		//ab jo cart me item dale hai usno remove ho kar do taki vo order ho jae..
		session.removeAttribute("cart");
		res.sendRedirect("order-success");
	}
	

}
