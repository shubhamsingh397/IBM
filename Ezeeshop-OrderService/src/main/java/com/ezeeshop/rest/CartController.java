package com.ezeeshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Cart;
import com.ezeeshop.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	@PostMapping("/cart")
	private ResponseEntity<CartObject> addtoCart(@RequestBody Cart cart)
	{
		service.addToCart(cart);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/cart/{username}")
	public CartObject getCart(@PathVariable("username")String userName)
	{
		return service.getCart(userName);
	}
	
	@DeleteMapping("/cart/{username}")
	public ResponseEntity<CartObject> deleteCart(@PathVariable("username")String userName)
	{
		service.deleteCart(userName);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/cart/{username}/{productId}")
	public ResponseEntity<CartObject> deleteCart(@PathVariable("username")String userName,@PathVariable("productId")Long id)
	{
		service.deleteProduct(userName, id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/cart")
	public ResponseEntity<CartObject> updateCart(@RequestBody Cart cart)
	{
		service.updateProductQuantity(cart);
		return ResponseEntity.noContent().build();
	}
	
}
