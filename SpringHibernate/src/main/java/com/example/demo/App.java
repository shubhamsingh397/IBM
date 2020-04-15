package com.example.demo;

import java.util.List;
import java.util.Scanner;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerService service;
	private static Scanner scanner = new Scanner(System.in);
	static
	{
		service = new CustomerServiceImpl();
	}
    public static void main( String[] args )
    {
        int choice = 0;
        do {
        System.out.println("1. AddCustomer");
        System.out.println("2. List All Customer");
        System.out.println("3. CustomerById");
        System.out.println("4. Delete CustomerById ");
        System.out.println("5. Update Customer");
        System.out.println("Enter the choice: ");
        choice = scanner.nextInt();
        
        switch(choice)
        {
        case 1:
        {
        	System.out.println("Enter the name");
        	String name = scanner.next();
        	System.out.println("Enter the Email");
        	String email = scanner.next();
        	
        	Customer obj = new Customer();
        	//obj.setCustomerId(UUID.randomUUID().toString());
        	obj.setCustomerName(name);
        	obj.setCustomerEmail(email);
        	obj.setActive(false);
        	
        	service.addCustomer(obj);
        	System.out.println("Added Successfully");
        	break;
        	
        	
        }
        case 2:
        {
        	List<Customer> list = service.getAllCustomer();
        	for(Customer obj : list)
        	{
        		System.out.println(obj);
        	}
        	break;
        }
        case 3:
        {
        	System.out.println("Enter the id");
        	long id = scanner.nextLong();
        	System.out.println(service.getById(id));
        	break;
        }
        case 4:
        {
        	System.out.println("Enter the id");
        	long id = scanner.nextLong();
        	service.deleteById(id);
        	System.out.println("Deleted");
        	break;
        }
        case 5:
        {
        	System.out.println("Enter the id");
        	long id = scanner.nextLong();
        	System.out.println("Enter the isActive status");
        	boolean isActive = scanner.nextBoolean();
        	service.updateById(id, isActive);
        	System.out.println("Updated");
        	
        	break;
        }
        }
        }while(choice!=0);
    }
}
