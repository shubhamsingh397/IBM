package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	private String customerEmail;
	private boolean isActive;
	
	@ManyToMany(mappedBy = "customer", cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Order> order;

	public Customer(String customerName, String customerEmail, boolean isActive) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.isActive = isActive;
	}

	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long cusotmerId) {
		this.customerId = cusotmerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public void addOrder(Order order) {
		this.order.add(order);
	}

	@Override
	public String toString() {
		return "Customer [cusotmerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", isActive=" + isActive + ", order=" + order + "]";
	}
	

	
	
}
