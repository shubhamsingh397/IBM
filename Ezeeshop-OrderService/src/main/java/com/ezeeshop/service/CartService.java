package com.ezeeshop.service;

import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Cart;

public interface CartService {

	public Cart addToCart(Cart cart);
	public CartObject getCart(String customerUserName);
	public void deleteCart(String customerUserName);
	public void updateProductQuantity(Cart cart);
	public void deleteProduct(String customerUserName,Long productId);
}
