package com.example.demo.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;
@Repository
public class OrderDaoImpl implements OrderDao {

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
	
	
	public Order addOrder(Order order) {
		Order obj = em.find(Order.class,order.getOrderId());
		if(obj == null)
		{
			em.getTransaction().begin();
			em.persist(order);
			em.getTransaction().commit();
			return order;
		}
		else
		{
			em.getTransaction().begin();
			em.merge(order);
			em.getTransaction().commit();
			return order;
		}
		
	}

	public Order getOrder(long id) {
		Order obj = em.find(Order.class,id);
		if(obj == null)
		{
			System.out.println("No data with id: " + id);
			return null;
		}
		else
			return obj;
	}

	public List<Order> getAllOrder(long customerId) {
		List<Order> list = em.createQuery("from Order", Order.class).getResultList();
		if(list.isEmpty())
		{
			System.out.println("No data is Available...");
			return null;
		}

		else
			return list;
	}

	public void deleteOrder(long id) {
		Order obj = em.find(Order.class,id);
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
