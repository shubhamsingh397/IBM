package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/processFormVersion2")
	public String processForm(HttpServletRequest request, Model model)
	{
		String msg = "Hey!"+request.getParameter("Name");
		model.addAttribute("message",msg);
		return "HelloWorld";
	}
	
	@RequestMapping("/processFormVersion3")
	public String processForm(@RequestParam("Name") String name,Model model)
	{
		String msg = "Yo!"+ name;
		model.addAttribute("message1", msg);
		return "HelloWorld";
	}
}
