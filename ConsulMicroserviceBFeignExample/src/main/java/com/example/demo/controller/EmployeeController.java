package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable("name")String name)
	{
		return  ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeByDept(name));
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.AddEmployee(employee));
	}
}
