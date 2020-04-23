package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.InstructorDetails;

public interface InstructorDetailsDao {

	public void addInstructorDetails(InstructorDetails instructor);
	public InstructorDetails getInstructorDetails(int id);
	public List<InstructorDetails> getAllInstructorDetails();
	public void deleteInstructorDetails(int id);
	public void updateInstructorDetails(InstructorDetails instructor);
 }
