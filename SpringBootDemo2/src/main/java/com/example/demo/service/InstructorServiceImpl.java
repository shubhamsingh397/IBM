package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstructorDao;
import com.example.demo.model.Instructor;
@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao dao;
	@Override
	public void addInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		dao.addInstructor(instructor);
	}

	@Override
	public Instructor getInstructor(int id) {
		// TODO Auto-generated method stub
		return dao.getInstructor(id);
	}

	@Override
	public List<Instructor> getAllInstructor() {
		// TODO Auto-generated method stub
		return dao.getAllInstructor();
	}

	@Override
	public void deleteInstructor(int id) {
		// TODO Auto-generated method stub
		dao.deleteInstructor(id);
	}

	@Override
	public void updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		dao.updateInstructor(instructor);
	}

}
