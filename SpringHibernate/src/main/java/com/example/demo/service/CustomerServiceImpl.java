package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.CustomerDaoImpl;
import com.example.demo.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao;
	{
		dao = new CustomerDaoImpl();
	}
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public Customer getById(long id) {
		return dao.getById(id);
	}

	@Override
	public void deleteById(long id) {
		dao.deleteById(id);
	}

	@Override
	public void updateById(long id, boolean isActive) {
		dao.updateById(id, isActive);
	}

}
