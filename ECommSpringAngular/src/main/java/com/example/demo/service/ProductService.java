package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Product;

public interface ProductService {

	public Page<Product> getAllProducts(int page,int size);
	public List<Product> getAllProductsByCategoryId(long id);
	public List<Product> getProductByName(String name);
	public Product getProduct(long id);
}
