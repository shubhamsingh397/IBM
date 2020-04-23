package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class InstructorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String course;
	public InstructorDetails(String course) {
		super();
		this.course = course;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Instructor instructor;
	public InstructorDetails() {
		super();
	}
	public InstructorDetails(String course, Instructor instructor) {
		super();
		this.course = course;
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", course=" + course + ", instructor=" + instructor + "]";
	}
}
