package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	private int streetNo = 123;
	private String streetName = "KalindiVihar";
	private String city = "Agra";
	private String country = "India";
}
