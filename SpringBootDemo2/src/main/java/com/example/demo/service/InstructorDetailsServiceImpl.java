package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstructorDetailsDao;
import com.example.demo.model.InstructorDetails;
@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

	@Autowired
	private InstructorDetailsDao dao;
	@Override
	public void addInstructorDetails(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		dao.addInstructorDetails(instructor);
	}

	@Override
	public InstructorDetails getInstructorDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getInstructorDetails(id);
	}

	@Override
	public List<InstructorDetails> getAllInstructorDetails() {
		// TODO Auto-generated method stub
		return dao.getAllInstructorDetails();
	}

	@Override
	public void deleteInstructorDetails(int id) {
		// TODO Auto-generated method stub
		dao.deleteInstructorDetails(id);
	}

	@Override
	public void updateInstructorDetails(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		dao.updateInstructorDetails(instructor);
	}

}
