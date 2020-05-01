package com.example.demo.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;
	private static final String QUEUE= "items-queue";
	
	@RabbitListener(queues = QUEUE)
	public void recieveMessage(Account account)
	{
		System.out.println("Items Recieved: "+account);
		dao.save(account);
	}
	
	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return (List<Account>) dao.findAll();
	}

	
	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

}
