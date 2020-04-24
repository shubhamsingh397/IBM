package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.AccountDao;
import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;

@Service
@EnableTransactionManagement
public class AccountDtoServiceImpl implements AccountDtoService{

	private AccountDao accountDao;

	public AccountDtoServiceImpl(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	@Override
	
	public List<AccountDto> getAllAccounts() {
		
		List<AccountDto> list = new ArrayList<>();
		accountDao.findAll().forEach(account ->{list.add(new AccountDto(account.getAccountId(),account.getAccountType()
				,account.getAccountBalance()));});
		return list;
	}

	@Override
	public AccountDto getAccountById(int id) {
		
		Optional<Account> ob = accountDao.findById(id);
		if (ob.isEmpty())
			return null;
			else
			{
				Account obj = ob.get();
				return new AccountDto(obj.getAccountId(),obj.getAccountType(),obj.getAccountBalance());
				
			}
		
		
	}

	@Override
	public AccountDto addAccount(AccountDto accountDto) {
		Account obj = accountDao.save(new Account(accountDto.getAccountId(),accountDto.getAccountType(),accountDto.getAccountBalance()));
		return new AccountDto(obj.getAccountId(),obj.getAccountType(),obj.getAccountBalance());
	}

	@Override
	public void deleteAccount(int id) {
		//accountDao.deleteByAccountId(id);
		accountDao.deleteById(id);
		
	}

	@Override
	public AccountDto updateAccount(Account account) {
		 Account obj = accountDao.save(account);
		 return new AccountDto(obj.getAccountId(),obj.getAccountType(),obj.getAccountBalance());
	}

	@Override
	public AccountDto getByAccountId(String id) {
		Optional<Account> ob = accountDao.findByAccountId(id);
		if (ob.isEmpty())
			return null;
			else
			{
				Account obj = ob.get();
				return new AccountDto(obj.getAccountId(),obj.getAccountType(),obj.getAccountBalance());
				
			}
	}

	@Override
	public List<AccountDto> getByAccountType(String type) {
		List<AccountDto> list = new ArrayList<>();
		accountDao.findByAccountType(type).forEach(account ->{list.add(new AccountDto(account.getAccountId(),account.getAccountType()
				,account.getAccountBalance()));});
		return list;
	}

	@Override
	@Transactional
	public void deleteByAccountId(String id) {
		// TODO Auto-generated method stub
		accountDao.removeByAccountId(id);
	
	}

	
	
	
	
	
}
