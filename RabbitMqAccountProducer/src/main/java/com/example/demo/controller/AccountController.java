package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@Api(value="Account Management System", description="Operations pertaining to Account in Account Management System")
public class AccountController {

	@Autowired
	private AccountService service;

	@ApiOperation(value = "Save an Account")
	
	
	
	 @GetMapping(value = "/admin/add")
		public String add(Model model) {
			model.addAttribute("account",new Account());
			return "accountForm";
		}
	 @PostMapping(value = "/addAccount")
	
		public String addAccount(@ApiParam(value = "AccountDto object to store in database table", required = true) Account account)
		{
			service.sendMessage(account);
			return "employeeAdded";
		}
	
}
