package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about the Instructor. ")
public class Instructor {
	@ApiModelProperty(notes = "The database generated instructor ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ApiModelProperty(notes = "The instructor first name")
	private String firstName;
	@ApiModelProperty(notes = "The instructor last name")
	private String lastName;
	@ApiModelProperty(notes = "One-One Bidirectional Mapping of Instructor with Instructor_Details")
	@OneToOne(mappedBy = "instructor",cascade = CascadeType.ALL)
	@JsonManagedReference
	private InstructorDetails details;

	public Instructor() {
		super();
	}

	public Instructor(String firstName, String lastName, InstructorDetails details) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.details = details;
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

	public InstructorDetails getDetails() {
		return details;
	}

	public void setDetails(InstructorDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", details=" + details
				+ "]";
	}

	
	
	
	
	

	
	
	
}
