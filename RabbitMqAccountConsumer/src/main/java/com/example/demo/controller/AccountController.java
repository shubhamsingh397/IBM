package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Account Management System", description="Operations pertaining to Account in Account Management System")
public class AccountController {

	@Autowired
	private AccountService service;
	
	
	@ApiOperation(value = "View a list of available Account")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return service.getAllAccount();
	}
	
	
	@ApiOperation(value = "Get an Account by Id")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable("id")int id)
	{
		return service.getAccount(id);
	}
	
	@ApiOperation(value = "Delete an Account")
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable("id")int id)
	{
		service.deleteAccount(id);
	}
	
	@ApiOperation(value = "Update an Account")
	@PutMapping("/accounts")
	public Account updateAccount(Account account)
	{
		return service.updateAccount(account);
	}
}
