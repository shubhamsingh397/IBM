package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.proxy.BClient;

@RestController
@RequestMapping("/dept")
public class AController {

	@Autowired
	private BClient client;
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> hello(@PathVariable("name") String name)
	{
		return client.callEmployee(name);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return client.addEmployee(employee);
	}
}
