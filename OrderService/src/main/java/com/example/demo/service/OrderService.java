package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;
import com.example.demo.entity.ShippingDetails;

public interface OrderService {

	public void saveOrder( ShippingDetails shippingDetails,String userName);
	public Order getOrderById(Long id);
	public List<Order> getOrderByUserName(String userName);
}

