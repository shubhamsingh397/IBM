package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getById(long id);
	public void deleteById(long id);
	public void updateById(long id,boolean isActive);
}
