package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	
	
	

	public Instructor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public Instructor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ",]";
	}
	
	
}
