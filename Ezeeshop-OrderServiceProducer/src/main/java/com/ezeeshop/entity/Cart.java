package com.ezeeshop.entity;

public class Cart {

	private Long CartId;
	
	private int quantity;
	
	private Long productId;
	private String customerUserName;
	public Long getCartId() {
		return CartId;
	}
	public void setCartId(Long cartId) {
		CartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	
	
	
	
	
	
	
}
