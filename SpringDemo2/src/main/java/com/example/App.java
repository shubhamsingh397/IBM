package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.example.service.DetailsServiceImpl;
import com.example.service.NameService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 NameService details = context.getBean("detailsService",DetailsServiceImpl.class);
		 
		 System.out.println(details.getDetails().getName());
		 System.out.println(details.getDetails().getEmail());
		 System.out.println(details.getDetails().getAddress().getHouseNo());
		 System.out.println(details.getDetails().getAddress().getCity());
		 System.out.println(details.getDetails().getAddress().getPincode());
		
    }
}
