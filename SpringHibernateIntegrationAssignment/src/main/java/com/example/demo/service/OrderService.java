package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Order;

public interface OrderService {
	public Order addOrder(Order order);
	public Order getOrder(long id);
	public List<Order> getAllOrder(long customerId);
	public void deleteOrder(long id);
}
