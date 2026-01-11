package com.ecommerce.model;

public class CartItem {
	private Product product;
	private int quantity;
	
	//constructor//
	public CartItem(Product product , int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//-- Total = (no. of products x Total quantity) --
	public double getTotal() {
		return product.getPrice() * quantity;
	}
	

}
