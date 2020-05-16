package com.ezeeshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.dto.CartObject;
import com.ezeeshop.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	
	
	@GetMapping("/cart/{username}")
	public CartObject getCart(@PathVariable("username")String userName)
	{
		return service.getCart(userName);
	}
	
	
 
}
