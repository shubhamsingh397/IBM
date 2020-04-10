package com.example.demo.dao;

import com.example.demo.model.Person;

import lombok.Setter;
@Setter
public class PersonDao {

	Person person;
	public Person getDetails()
	{
		return person;
	}
}
