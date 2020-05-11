package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comm.ProductCom;
import com.example.demo.entity.Product;
@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private ProductCom com;
	
	@GetMapping("api/products")
	public ResponseEntity<List<Product>> getProducts()
	{
		return com.getAllProducts();
	}
	@GetMapping("api/products/findByCategoryId")
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam long id)
	{
		return com.findByCategoryId(id);
	}
}
