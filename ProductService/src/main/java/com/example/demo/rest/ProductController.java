package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id")Long id)
	{
		return service.getProduct(id);
	}
}
