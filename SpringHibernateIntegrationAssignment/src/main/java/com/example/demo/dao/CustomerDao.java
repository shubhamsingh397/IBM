package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {

	public Customer addCustomer(Customer speaker);
	public Customer getCustomer(long id);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(long id);
}
