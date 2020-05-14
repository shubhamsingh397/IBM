package com.example.demo.comm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;

@FeignClient(value = "ecomm")
public interface ProductCom {
	@GetMapping("/api/products")
	public PagedModel<Product> getAllProducts();
	@GetMapping("api/productsBycategory")
	public ResponseEntity<List<Product>> findByCategoryId(@RequestParam long id);
	
	@GetMapping("api/product-category")
	public EntityModel<ProductCategory> getAllCategory();
	
	@GetMapping("api/products/findByName")
	public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name);
	
	@GetMapping("/api/products/{id}")
	public Product getProduct(@PathVariable("id") long id);
}