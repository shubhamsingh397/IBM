package com.example.demo.fallback;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.comm.ProductCom;
import com.example.demo.entity.Product;


  @Component public class EmployeeFallback implements ProductCom{
  
  @Override
  public ResponseEntity<List<Product>> getAllProducts() {
	  // TODO Auto-generated method stub
	  return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
	  }

@Override
public ResponseEntity<List<Product>> findByCategoryId(long id) {
	// TODO Auto-generated method stub
	return new ResponseEntity("Service Down",HttpStatus.SERVICE_UNAVAILABLE);
}
  
  }
 
