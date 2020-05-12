package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query
	public List<Product> findByCategoryId(Long id);
	
	@Query
	public List<Product> findByNameContaining(String name);
}