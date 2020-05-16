package com.ezeeshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.entity.Order;
import com.ezeeshop.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	
	
	@GetMapping("/ordersByUserName/{username}")
	public ResponseEntity<List<Order>> getOrder(@PathVariable("username")String userName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrderByUserName(userName));
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id")Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrderById(id));
	}
	
}
