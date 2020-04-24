package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(description="All details about the AccountTable. ")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "account_number",nullable = false)
	@ApiModelProperty(notes = "The database generated Account Number")
	private int accountNumber;
	
	@Column(name="customer_relationship_number")
	@ApiModelProperty(notes = "The accountId of AccountTable")
	private String accountId;
	
	@Column(name="account_type")
	@ApiModelProperty(notes = "The accountType of AccountTable")
	private String accountType;
	
	@Column(name="account_balance")
	@ApiModelProperty(notes = "The accountBalance of AccountTable")
	private double accountBalance;
	
	
	
	public Account(String accountId, String accountType, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	public Account() {
		super();
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	
}
