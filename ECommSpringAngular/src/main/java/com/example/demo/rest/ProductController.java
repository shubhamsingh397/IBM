package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/api/products")
	public List<Product> getProducts()
	{
		return service.getAllProducts();
	}
	@GetMapping("/api/productsBycategory")
	public List<Product> findByCategoryId(@RequestParam long id)
	{
		return service.getAllProductsByCategoryId(id);
	}
}
