package com.ezeeshop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ezeeshop.dto.Product;
import com.ezeeshop.feign.ProductClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication implements CommandLineRunner{

	@Autowired
	private EntityManager em;
	@Autowired 
	private ProductClient client;
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = client.getAllProduct();
		for(Product obj: list)
		{
			em.persist(obj);
		}
	}

}
