package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Instructor;
@Repository
public class InstuctorDaoImpl implements InstructorDao{

	@Autowired
	private EntityManager em;
	@Override
	@Transactional
	public void addInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		em.persist(instructor);
		//instructor.setDetails(instructor.getDetails());
	}

	@Override
	public Instructor getInstructor(int id) {
		// TODO Auto-generated method stub
		return em.find(Instructor.class, id);
	}

	@Override
	public List<Instructor> getAllInstructor() {
		List<Instructor> list = em.createQuery("from Instructor",Instructor.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {

		Instructor obj = em.find(Instructor.class,id);
		em.remove(obj);
		
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		em.merge(instructor);
		
	}

}
