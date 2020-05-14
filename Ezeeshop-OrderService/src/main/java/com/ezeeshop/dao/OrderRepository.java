package com.ezeeshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezeeshop.dto.Product;
import com.ezeeshop.entity.Order;
import com.ezeeshop.entity.ShippingDetails;

@Repository
public class OrderRepository {

	@Autowired
	private EntityManager em;
	
	public ShippingDetails getBillingAddress(Long id)
	{
		return em.find(ShippingDetails.class, id);
	}
	
	public List<Order> getOrderByUserName(String customerUserName)
	{
		TypedQuery<Order> query = em.createQuery("select o FROM Order o where o.customerUserName=:username", Order.class);
		query.setParameter("username", customerUserName);
		List<Order> list = query.getResultList();
		return list;
	}
	
	public Order getOderById(Long id)
	{
		return em.find(Order.class,id);
	}
	
	@Transactional
	public void placeOrder(Order order, ShippingDetails shippingDetails, List<Product> products)
	{
		
		em.persist(shippingDetails);
		em.persist(order);
		order.setProduct(products);
		order.setAddress(shippingDetails);
		
		
	}
	
	
}
