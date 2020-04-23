package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InstructorDetails;
@Repository
public class InstuctorDaoImpl implements InstructorDao{

	@Autowired
	private EntityManager em;
	@Override
	@Transactional
	public void addInstructor(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		em.persist(instructor);
	}

	@Override
	public InstructorDetails getInstructor(int id) {
		// TODO Auto-generated method stub
		return em.find(InstructorDetails.class, id);
	}

	@Override
	public List<InstructorDetails> getAllInstructor() {
		List<InstructorDetails> list = em.createQuery("from InstructorDetails",InstructorDetails.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {

		InstructorDetails obj = em.find(InstructorDetails.class,id);
		em.remove(obj);
		
	}

	@Override
	@Transactional
	public void updateInstructor(InstructorDetails instructor) {
		// TODO Auto-generated method stub
		em.merge(instructor);
	}

}
