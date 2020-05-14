package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.Product;

@FeignClient(value = "product")
public interface ProductClient {

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") Long id);
	
	@GetMapping("/products")
	public List<Product> getAllProduct();
}
