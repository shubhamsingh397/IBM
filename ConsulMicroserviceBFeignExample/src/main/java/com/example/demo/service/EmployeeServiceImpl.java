package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDao dao;
	

	@Autowired
	public EmployeeServiceImpl(EmployeeDao dao) {
		super();
		this.dao = dao;
	}


	@Override
	public List<Employee> getEmployeeByDept(String name) {
		// TODO Auto-generated method stub
		return (List<Employee>) dao.findByDepartment(name);
	}


	@Override
	public Employee AddEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee);
	}

	
}
