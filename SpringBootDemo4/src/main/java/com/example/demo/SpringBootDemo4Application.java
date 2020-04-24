package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ImageRepo;

@SpringBootApplication
public class SpringBootDemo4Application {
	private ImageRepo imageRepo;

	@Autowired
	public SpringBootDemo4Application(ImageRepo imageRepo) {
		super();
		this.imageRepo = imageRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo4Application.class, args);
	}

}
