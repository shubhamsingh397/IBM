package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Order;

public interface OrderDao {

	public Order addOrder(Order order);
	public Order getOrder(long id);
	public List<Order> getAllOrder(long customerId);
	public void deleteOrder(long id);
}
