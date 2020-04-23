package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetails;
@Repository
public class InstuctorDetailsDaoImpl implements InstructorDetailsDao{

	@Autowired
	private EntityManager em;
	@Override
	@Transactional
	public void addInstructorDetails(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		
		em.persist(instructor);
		//instructor.setInstructor(instructor.getInstructor());
		
	}

	@Override
	public InstructorDetails getInstructorDetails(int id) {
		// TODO Auto-generated method stub
		return em.find(InstructorDetails.class, id);
	}

	@Override
	public List<InstructorDetails> getAllInstructorDetails() {
		List<InstructorDetails> list = em.createQuery("from InstructorDetails",InstructorDetails.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public void deleteInstructorDetails(int id) {

		InstructorDetails obj = em.find(InstructorDetails.class,id);
		em.remove(obj);
		
	}

	@Override
	@Transactional
	public void updateInstructorDetails(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		
		em.merge(instructor);
	}

}
