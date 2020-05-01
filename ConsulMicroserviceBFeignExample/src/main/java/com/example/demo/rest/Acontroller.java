package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Acontroller {

	@GetMapping("/hi")
	public String sayhelo(@RequestParam String name)
	{
		return "hi "+name;
	}
	
}
