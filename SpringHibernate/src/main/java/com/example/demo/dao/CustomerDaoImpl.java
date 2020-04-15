package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.demo.factory.MyHibernateFactory;
import com.example.demo.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	private MyHibernateFactory factory = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;
	
	{
		factory = MyHibernateFactory.getMyHibernateFactory();
		sessionFactory = factory.getSessionFactory();
		session = sessionFactory.openSession();
	}
	@Override
	public void addCustomer(Customer customer) {
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = session.createQuery("from Customer", Customer.class).list();
		return list;
	}

	@Override
	public Customer getById(long id) {
		return session.find(Customer.class, id);
	}

	@Override
	public void deleteById(long id) {

		session.getTransaction().begin();
		Customer customer = session.find(Customer.class, id);
		session.remove(customer);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateById(long id, boolean isActive) {
		session.getTransaction().begin();
		Customer customer = session.find(Customer.class, id);
		customer.setActive(true);
		session.getTransaction().commit();
	}

}
