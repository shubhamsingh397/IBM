package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {

	public List<Account> getAllAccount();
	
	public Account getAccount(int id);
	public void deleteAccount(int id);
	public Account updateAccount(Account account);

}