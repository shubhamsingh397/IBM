package com.example.demo.dto;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel(description="All details about the AccountDTO. ")
public class AccountDto {
	@ApiModelProperty(notes = "The accountId of AccountDtoTable")
	private String accountId;
	@ApiModelProperty(notes = "The accountId of AccountDtoTable")
	private String accountType;
	@ApiModelProperty(notes = "The accountId of AccountDtoTable")
	private double accountBalance;
	public AccountDto(String accountId, String accountType, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	public AccountDto() {
		super();
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	
}
