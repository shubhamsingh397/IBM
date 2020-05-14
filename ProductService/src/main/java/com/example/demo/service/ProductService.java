package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public Product getProduct(Long id);
}
