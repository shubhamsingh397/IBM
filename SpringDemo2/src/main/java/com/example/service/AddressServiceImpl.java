package com.example.service;

import com.example.model.Address;

import lombok.Setter;

@Setter
public class AddressServiceImpl implements AddressService{

	private Address address;
	public Address getAddress() {
		
		address.setCity("agra");
		address.setHouseNo(123);
		address.setPincode(20202);
		return address;
	}

}
