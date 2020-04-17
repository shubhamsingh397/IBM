package com.example.demo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager em;

	@PostConstruct
	public void init()
	{
		factory = sessionFactory.unwrap(SessionFactory.class);
		em = factory.createEntityManager();
	}
	
	public Customer addCustomer(Customer customer) {
		
		Customer obj = em.find(Customer.class,customer.getCustomerId());
		if(obj == null)
		{
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			return customer;
		}
		else
		{em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
			return customer;
		}
	}

	public Customer getCustomer(long id) {
		
		Customer obj = em.find(Customer.class,id);
		if(obj == null)
		{
			System.out.println("No data with id: " + id);
			return null;
		}
		else
			return obj;
	}

	public List<Customer> getAllCustomer() {

		List<Customer> list = em.createQuery("from Customer", Customer.class).getResultList();
		if(list.isEmpty())
		{
			System.out.println("No data is Available...");
			return null;
		}

		else
			return list;
	}

	public void deleteCustomer(long id) {
		Customer obj = em.find(Customer.class,id);
		if(obj==null)
		{
			System.out.println("No data with id: " +id);
			return;
		}
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

}
