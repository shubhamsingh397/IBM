package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.Account;
import com.example.demo.service.AccountDtoService;

@SpringBootApplication
public class SpringBootDemo3Application implements CommandLineRunner {

	private AccountDao accountDao;
	private AccountDtoService accountService;
	
	
	public SpringBootDemo3Application(AccountDao accountDao, AccountDtoService accountService) {
		super();
		this.accountDao = accountDao;
		this.accountService = accountService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo3Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * accountDao.save(new Account(UUID.randomUUID().toString(), "Savings", 10000));
		 * accountDao.save(new Account(UUID.randomUUID().toString(), "Credit Card",
		 * 3500)); accountDao.save(new Account(UUID.randomUUID().toString(), "Loan",
		 * 1500)); System.out.println(accountService.getAllAccounts().toString());
		 */
	}

}
