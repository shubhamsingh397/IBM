package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(long id);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(long id);
}
