package com.ezeeshop.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dao.OrderRepository;
import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Order;
import com.ezeeshop.entity.ShippingDetails;

@Service
public class OrderServicerImpl implements OrderService{

	@Autowired
	private OrderRepository dao;
	@Autowired
	private CartService cartService;
	@Override
	public void saveOrder(ShippingDetails shippingDetails,String userName) {
		// TODO Auto-generated method stub
		CartObject cart = cartService.getCart(userName);
		Order order = new Order();
		order.setCustomerUserName(userName);
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("Delivered");
		order.setTotalAmount(cart.getTotalPrice());
		dao.placeOrder(order,shippingDetails,cart.getProductList());
	}

	@Override
	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
		return dao.getOderById(id);
	}

	@Override
	public List<Order> getOrderByUserName(String userName) {
		// TODO Auto-generated method stub
		return dao.getOrderByUserName(userName);
	}

}
