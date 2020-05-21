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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="EzeeShop Order Consumer Service", description="Operations pertaining to Order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	
	
	@GetMapping("/ordersByUserName/{username}")
	@ApiOperation(value = "Retrieving the List of Orders associated with customerUserName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<List<Order>> getOrder(@PathVariable("username")String userName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrderByUserName(userName));
	}
	
	@GetMapping("/orders/{id}")
	@ApiOperation(value = "Retrieving Order with orderId associated with customerUserName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<Order> getOrderById(@PathVariable("id")Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getOrderById(id));
	}
	
}
