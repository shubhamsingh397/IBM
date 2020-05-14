package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.entity.ShippingDetails;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/orders")
	public ResponseEntity placeOrder(@RequestBody ShippingDetails shippingDetails,@RequestParam String userName)
	{
		service.saveOrder(shippingDetails, userName);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/ordersByUserName/{username}")
	public List<Order> getOrder(@PathVariable("username")String userName)
	{
		return service.getOrderByUserName(userName);
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id")Long id)
	{
		return service.getOrderById(id);
	}
}
