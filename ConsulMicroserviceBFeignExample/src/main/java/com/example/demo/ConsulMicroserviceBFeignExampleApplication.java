package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@SpringBootApplication
@EnableDiscoveryClient

public class ConsulMicroserviceBFeignExampleApplication implements CommandLineRunner {

	private EmployeeDao dao;
	@Autowired
	public ConsulMicroserviceBFeignExampleApplication(EmployeeDao dao) {
		super();
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsulMicroserviceBFeignExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dao.save(new Employee("shubham","Singh","IT"));
		dao.save(new Employee("Ghulam","Mozammil","IT"));
		dao.save(new Employee("Pranav","Kumar","ADMIN"));	}

}
