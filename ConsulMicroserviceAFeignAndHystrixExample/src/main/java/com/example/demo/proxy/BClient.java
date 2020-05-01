package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.fallback.ServiceFallback;
import com.example.demo.model.Employee;

@FeignClient(value = "service-b" , fallback = ServiceFallback.class )
public interface BClient {

	@GetMapping("/employee/{name}")
	public ResponseEntity<List<Employee>> callEmployee(@PathVariable("name") String name);

	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);
	
}
