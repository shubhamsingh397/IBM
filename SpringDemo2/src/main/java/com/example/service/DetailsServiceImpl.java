package com.example.service;

import com.example.model.Name;

import lombok.Setter;

@Setter
public class DetailsServiceImpl implements NameService {

	private Name name;
	private AddressService address;
	public Name getDetails() {
		name.setName("abc");
		name.setEmail("abc@gmail.com");
		name.setAddress(address.getAddress());
		return name;
		
	}

	
}
