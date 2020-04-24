package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;

public interface AccountDtoService {

	public AccountDto addAccount(AccountDto accountDto);
	public List<AccountDto> getAllAccounts();
	public AccountDto getAccountById(int id);
	public void deleteAccount(int id);
	public void deleteByAccountId(String id);
	public AccountDto getByAccountId(String id);
	public List<AccountDto> getByAccountType(String type);
	public AccountDto updateAccount(Account account);
}
