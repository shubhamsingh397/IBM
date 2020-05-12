package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.service.ProductCategoryService;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	@Autowired
	private ProductCategoryService catService;
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
	@GetMapping("/api/products/{id}")
	public Product getProduct(@PathVariable("id") long id)
	{
		return service.getProduct(id);
	}
	@GetMapping("api/product-category")
	public List<ProductCategory> getAllCategory()
	{
		return catService.getAllCategory();
	}
	@GetMapping("api/products/findByName")
	public List<Product> getAllProductByName(@RequestParam String name)
	{
		return service.getProductByName(name);
	}
	
}
