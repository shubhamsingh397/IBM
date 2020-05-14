package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;
	private String productName;
	private int productPrice;
	public Product(String productName, int productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
