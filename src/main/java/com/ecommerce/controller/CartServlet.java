package com.ecommerce.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ecommerce.model.CartItem;
import com.ecommerce.service.CartService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		//Cart me dalna hai to use Map..
		Map<Integer,CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
		
		//Agar Cart Kahli hai to naya HashSpace Dedo
		if(cart == null) {
			cart = new HashMap<>();
		}
		
		//Ab jaise jaise user cart me dalta jae to add+1 krdo
		
		int id = Integer.parseInt(req.getParameter("id"));
		new CartService().addToCart(cart, id);
		
		
		session.setAttribute("cart", cart);
		
		
		//fir redirect krdo output jsp par.
		res.sendRedirect("view-cart");
		
	}
	

}
