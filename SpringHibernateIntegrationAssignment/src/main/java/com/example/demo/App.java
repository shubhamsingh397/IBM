package com.example.demo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;
import com.example.demo.service.OrderService;
import com.example.demo.service.OrderServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         
         CustomerService customerService =  context.getBean("customerServiceImpl",CustomerServiceImpl.class);
         OrderService   orderService = context.getBean("orderServiceImpl",OrderServiceImpl.class);
         
         
         int choice = 0;
         do {
        	 System.out.println("1.Menu for Customer");
        	 System.out.println("2.Menu for Order");
        	 
        	 choice = scanner.nextInt();
        	 switch(choice)
        	 {
        	 case 1:
        	 {
        		 int choice1 = 0;
        	        do {
        	        System.out.println("1. Add Customer");
        	        System.out.println("2. Add Order to Customer");
        	        System.out.println("3. Customer By Id");
        	        System.out.println("4. List All Customer");
        	        System.out.println("5. Delete Customer By Id ");
        	        System.out.println("Enter the choice: ");
        	        choice1 = scanner.nextInt();
        	        
        	        switch(choice1)
        	        {
        	        case 1:
        	        {
        	        	System.out.println("Enter the name");
        	        	String name = scanner.next();
        	        	System.out.println("Enter the email");
        	        	String email = scanner.next();
        	        	System.out.println("Enter the isActive Status");
        	        	boolean isAvailable = scanner.nextBoolean();
        	        	Customer ob = customerService.addCustomer(new Customer(name,email,isAvailable));
        	        	System.out.println("Added Successfully" + ob);
        	        	break;
        	        	
        	        	
        	        }
        	        case 2:
        	        {
        	        	
        	        	System.out.println("Enter the Customer id");
        	          	long cid = scanner.nextLong();
        	          	System.out.println("Enter the Order id");
        	          	long oid = scanner.nextLong();
        	          	Customer ob1 = customerService.getCustomer(cid);
        	          	Order ob2 = orderService.getOrder(oid);
        	          	
        	          	ob2.addCustomer(ob1);
        	          	ob1.addOrder(ob2);
        	          	customerService.addCustomer(ob1);
        	          	break;
        	        	
        	        }
        	        case 3:
        	        {
        	        	System.out.println("Enter the id");
        	        	long id = scanner.nextLong();
        	        	System.out.println(customerService.getCustomer(id));
        	        	break;
        	        }
        	        case 4:
        	        {
        	        	List<Customer> list = customerService.getAllCustomer();
        	        	for(Customer obj4 : list)
        	        	{
        	        		System.out.println(obj4);
        	        	}
        	        	break;
        	        	
        	        }
        	        case 5:
        	        {
        	        	System.out.println("Enter the id");
        	        	long id = scanner.nextLong();
        	        	customerService.deleteCustomer(id);
        	        	//System.out.println("Deleted");
        	        	break;
        	        }
        	        }
        	        }while(choice1!=0);
        	        break;
        	 }
        	 case 2:{
        		 int choice2 = 0;
     	        do {
     	        System.out.println("1. Add Order");
     	        System.out.println("2. Add Customer to Order");
     	        System.out.println("3. Order By Id");
     	        System.out.println("4. List All Order");
     	        System.out.println("5. Delete Order By Id ");
     	        System.out.println("Enter the choice: ");
     	        choice2 = scanner.nextInt();
     	        
     	        switch(choice2)
     	        {
     	        case 1:
     	        {
     	        	System.out.println("Enter the Product name");
     	        	String name = scanner.next();
     	        	System.out.println("Enter the Product price");
     	        	int price = scanner.nextInt();
					/*
					 * System.out.println("Enter the date"); Date date = scanner.
					 */
     	        	Order ob = orderService.addOrder(new Order(name,price,new Date(2020-04-16)));
     	        	System.out.println("Added Successfully" + ob);
     	        	break;
     	        	
     	        	
     	        }
     	        case 2:
     	        {
     	        	
     	        	System.out.println("Enter the Order id");
     	          	long eid = scanner.nextLong();
     	          	System.out.println("Enter the Customer id");
     	          	long sid = scanner.nextLong();
     	          	Customer ob1 = customerService.getCustomer(sid);
     	          	Order ob2 = orderService.getOrder(eid);
     	            ob1.addOrder(ob2);
     	          	ob2.addCustomer(ob1);
     	          	
     	          	orderService.addOrder(ob2);
     	          	break;
     	        	
     	        }
     	        case 3:
     	        {
     	        	System.out.println("Enter the id");
     	        	long id = scanner.nextLong();
     	        	System.out.println(orderService.getOrder(id));
     	        	break;
     	        }
     	        case 4:
     	        {
     	        	List<Order> list = orderService.getAllOrder(1);
     	        	for(Order obj3 : list)
     	        	{
     	        		System.out.println(obj3);
     	        	}
     	        	break;
     	        	
     	        }
     	        case 5:
     	        {
     	        	System.out.println("Enter the id");
     	        	long id = scanner.nextLong();
     	        	orderService.deleteOrder(id);
     	        	//System.out.println("Deleted");
     	        	break;
     	        }
     	        }
     	        }while(choice2!=0);
     	        break;
        	 }
        	 }
         }while(choice !=0);
    }
}
