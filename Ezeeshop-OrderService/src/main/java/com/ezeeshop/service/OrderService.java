package com.ezeeshop.service;

import java.util.List;

import com.ezeeshop.entity.Order;
import com.ezeeshop.entity.ShippingDetails;

public interface OrderService {

	public void saveOrder( ShippingDetails shippingDetails,String userName);
	public Order getOrderById(Long id);
	public List<Order> getOrderByUserName(String userName);
}

