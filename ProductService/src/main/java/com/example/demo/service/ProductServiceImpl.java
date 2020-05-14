package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository dao;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) dao.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	
}
