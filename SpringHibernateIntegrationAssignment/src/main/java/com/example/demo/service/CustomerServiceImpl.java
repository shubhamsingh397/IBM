package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;
	@Override
	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	public Customer getCustomer(long id) {
		// TODO Auto-generated method stub
		return dao.getCustomer(id);
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(id);
	}

	

}
