package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Account;

@org.springframework.stereotype.Service
public class AccountService {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String EXCHANGE= "otp-exchange";
	private String ROUTING_KEY = "items";
	
	
	public void sendMessage(Account account)
	{
		amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,account);
	}
}
