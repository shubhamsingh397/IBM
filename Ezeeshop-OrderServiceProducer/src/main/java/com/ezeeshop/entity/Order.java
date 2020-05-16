package com.ezeeshop.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private Long orderId;
	private String customerUserName;
	private LocalDate orderDate;
	private String orderStatus;
	private int totalAmount;

	private ShippingDetails address;
	private List<Product> product = new ArrayList<Product>();

	
	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}

	public ShippingDetails getAddress() {
		return address;
	}

	public void setAddress(ShippingDetails address) {
		this.address = address;
	}
	
	
	
}
