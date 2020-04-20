package com.example.model;

import java.util.LinkedHashMap;

public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String,String> countryNames;
	private String favoriteLanguage;
	private String[] operatingSystem;
	

	public Student() {
		
		// populate country options: used ISO country code
		countryNames = new LinkedHashMap<>();
		
		countryNames.put("BR", "Brazil");
		countryNames.put("IN", "India");
		countryNames.put("US", "United States of America");		

	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap<String, String> getCountryNames() {
		return countryNames;
	}


	public void setCountryNames(LinkedHashMap<String, String> countryNames) {
		this.countryNames = countryNames;
	}


	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String[] getOperatingSystem() {
		return operatingSystem;
	}


	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
