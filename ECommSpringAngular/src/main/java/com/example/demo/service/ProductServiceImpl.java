package com.example.demo.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

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
	public Page<Product> getAllProducts(int size,int page ) {
		// TODO Auto-generated method stub
		return dao.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Product> getAllProductsByCategoryId(long id) {
		// TODO Auto-generated method stub
		return dao.findByCategoryId(id);
	}
	@Override
	public List<Product> getProductByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByNameContaining(name);
	}
	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	
}
