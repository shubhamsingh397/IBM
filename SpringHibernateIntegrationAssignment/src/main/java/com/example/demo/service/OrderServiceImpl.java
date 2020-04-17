package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.Order;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return dao.addOrder(order);
	}

	public Order getOrder(long id) {
		// TODO Auto-generated method stub
		return dao.getOrder(id);
	}

	public List<Order> getAllOrder(long customerId) {
		// TODO Auto-generated method stub
		return dao.getAllOrder(customerId);
	}

	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		dao.deleteOrder(id);
	}



	
	

}
