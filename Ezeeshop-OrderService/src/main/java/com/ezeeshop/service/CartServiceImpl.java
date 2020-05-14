package com.ezeeshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dao.CartRepository;
import com.ezeeshop.dto.CartObject;
import com.ezeeshop.dto.Product;
import com.ezeeshop.entity.Cart;
import com.ezeeshop.feign.ProductClient;

@Service
public class CartServiceImpl implements CartService{

	private CartRepository dao;
	private ProductClient productClient;
	//private CustomerClient customerClient;
	@Autowired
	public CartServiceImpl(CartRepository dao, ProductClient productClient) {
		super();
		this.dao = dao;
		this.productClient = productClient;
		//this.customerClient = customerClient;
	}
	@Override
	public Cart addToCart(Cart cart) {
		return dao.save(cart);
	}
	@Override
	public CartObject getCart(String customerUserName) {
		// TODO Auto-generated method stub
		List<Cart> cart = dao.findByCustomerUserName(customerUserName);
		CartObject obj = new CartObject(); 
		List<Product> productList = new ArrayList<Product>();
		int totalPrice = 0;
		for(Cart objCart : cart)
		{
			Product product = productClient.getProduct(objCart.getProductId());
			product.setQuantity(objCart.getQuantity());
			totalPrice += product.getProductPrice()*objCart.getQuantity();
			productList.add(product);
			
		}
		obj.setCustomerUserName(customerUserName);
		obj.setProductList(productList);
		obj.setTotalPrice(totalPrice);
		return obj;
	}
	@Override
	public void deleteCart(String customerUserName) {
		dao.deleteByCustomerUserName(customerUserName);
		
	}
	@Override
	public void updateProductQuantity(Cart cart) {
		// TODO Auto-generated method stub
		//Cart cart = dao.findByCustomerUserNameAndProductId(customerUserName, productId);
		if(cart.getQuantity()==0)
			dao.deleteByCustomerUserNameAndProductId(cart.getCustomerUserName(), cart.getProductId());
		else
		dao.updateProduct(cart.getCustomerUserName(), cart.getProductId(), cart.getQuantity());
	}
	@Override
	public void deleteProduct(String customerUserName, Long productId) {
		dao.deleteByCustomerUserNameAndProductId(customerUserName, productId);
		
	}
	

	

}
