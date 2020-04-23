package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Instructor;

public interface InstructorDao {

	public void addInstructor(Instructor instructor);
	public Instructor getInstructor(int id);
	public List<Instructor> getAllInstructor();
	public void deleteInstructor(int id);
	public void updateInstructor(Instructor instructor);
 }
