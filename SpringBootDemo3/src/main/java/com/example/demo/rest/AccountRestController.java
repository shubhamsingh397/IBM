package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.service.AccountDtoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value="Account Management System", description="Operations pertaining to Account in Account Management System")
public class AccountRestController {

	private AccountDtoService accountService;

	public AccountRestController(AccountDtoService accountService) {
		super();
		this.accountService = accountService;
	}
	@PostMapping("/add")
	@ApiOperation(value = "Add an Account")
	public AccountDto addAccount(@ApiParam(value = "AccountDto object to store in database table", required = true)@RequestBody AccountDto accountDto)
	{
		return accountService.addAccount(accountDto);
	}
	
	@GetMapping("/getAllAccounts")
	@ApiOperation(value = "View a list of available Account")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public List<AccountDto> getAllAccounts()
	{
		return accountService.getAllAccounts();
		
	}
	
	@GetMapping("/getById/{id}")
	@ApiOperation(value = "Get an Account by Id")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public AccountDto getById(@PathVariable("id")int id) throws AccountNotFoundException
	{
		AccountDto obj = accountService.getAccountById(id);
		if(obj == null)
			throw new AccountNotFoundException("No account with id: "+id);
		else
			return obj;
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete an Instructor")
	public void delete(@ApiParam(value = "Instructor Id from which account object will delete from database table", required = true)
	                                                                      @PathVariable("id")int id) throws AccountNotFoundException
	{
		AccountDto obj = accountService.getAccountById(id);
		if(obj == null)
			throw new AccountNotFoundException("No account with id: "+id);
		else
		accountService.deleteAccount(id);
	}

	
	  @DeleteMapping("/delete1/{id}")
	  
	  @ApiOperation(value = "Delete an Instructor by AccountId")
	  public void delete(@ApiParam(value = "Account Id from which account object will delete from database table",required = true)
	                                                     @PathVariable("id")String id) throws AccountNotFoundException
	  { 
		  //AccountDtoobj = accountService.getAccountById(id);
		  //if(obj == null)
		  //throw new AccountNotFoundException("No account with id: "+id);
		  // else
	        accountService.deleteByAccountId(id); }
	 
	@PutMapping("/update")
	@ApiOperation(value = "Update an Instructor")
	public AccountDto updateAccount(@ApiParam(value = "Account Object to update account object", required = true)@RequestBody Account account)
	{
		return accountService.updateAccount(account);
	}
	
	@GetMapping("/getByAccountId/{id}")
	@ApiOperation(value = "Get an Account by AccountId")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public AccountDto getByAccountId(@PathVariable("id")String id) throws AccountNotFoundException
	{
		AccountDto obj = accountService.getByAccountId(id);
		if(obj == null)
			throw new AccountNotFoundException("No account with id: "+id);
		else
			return obj;
	}
	
	@GetMapping("/getByAccountType/{id}")
	@ApiOperation(value = "Get an Account by AccountId")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public List<AccountDto> getByAccountType(@PathVariable("id")String type) throws AccountNotFoundException
	{
		List<AccountDto> obj = accountService.getByAccountType(type);
		if(obj == null)
			throw new AccountNotFoundException("No account with Type: "+type);
		else
			return obj;
	}
	
}
