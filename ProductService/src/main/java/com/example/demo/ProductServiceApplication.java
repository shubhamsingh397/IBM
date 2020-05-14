package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository dao;
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.save(new Product("Mobile",12000));
		dao.save(new Product("Laptop",40000));
		dao.save(new Product("Earphone",1200));
		dao.save(new Product("cloth",1500));
	}

}
