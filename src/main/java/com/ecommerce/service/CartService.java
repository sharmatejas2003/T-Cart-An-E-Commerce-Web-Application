package com.ecommerce.service;

import java.util.Map;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;

public class CartService {
	public void addToCart(Map<Integer,CartItem> cart , int productId) {
		ProductDAO dao = new ProductDAO();
		Product product = dao.findById(productId);
		///agar cart me already hai product to usme ek or add krdega
		if(cart.containsKey(productId)) {
			cart.get(productId).setQuantity(cart.get(productId).getQuantity()+1);
		}
		// varna new product dalega from CartItem se
		else {
			cart.put(productId, new CartItem(product,1));
		}
	}

}
