package com.example.service;

import com.example.model.Address;

import lombok.Setter;

@Setter
public class AddressServiceImpl implements AddressService{

	private Address address;
	public Address getAddress() {
		
		
		return address;
	}

}
