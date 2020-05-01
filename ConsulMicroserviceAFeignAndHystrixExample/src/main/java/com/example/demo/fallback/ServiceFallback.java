package com.example.demo.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.proxy.BClient;
@Component 
public class ServiceFallback implements BClient{
  
  @Override 
  public ResponseEntity<List<Employee>> callEmployee(String name)
  {
	  return new ResponseEntity("Service Down", HttpStatus.SERVICE_UNAVAILABLE);

  }

@Override
public ResponseEntity<Employee> addEmployee(Employee employee) {
	// TODO Auto-generated method stub
	 return new ResponseEntity("Service Down", HttpStatus.SERVICE_UNAVAILABLE);
}
  
  
  }
 