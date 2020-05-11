package com.example.demo.comm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.fallback.EmployeeFallback;

@FeignClient(value = "ecommservice")
public interface ProductCom {
	@GetMapping("/api/products")
	public ResponseEntity<List<Product>> getAllProducts();
	@GetMapping("api/productsBycategory")
	public ResponseEntity<List<Product>> findByCategoryId(@RequestParam long id);
}