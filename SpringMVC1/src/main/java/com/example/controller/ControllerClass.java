package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerClass {

	@GetMapping("/")
	public String getReq()
	{
		return "main-menu";
	}
	
	@RequestMapping("/processHelloWorldForm")
	public String processForm() {
		return "HelloWorld";
	}
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "HelloWorld-Form";
	}
}
