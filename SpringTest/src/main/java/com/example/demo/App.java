package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	PersonDao dao = context.getBean("personDao",PersonDao.class);
    	System.out.println(getdetails(dao));
    }
    
    public static String getdetails(PersonDao dao)
    {
    	Person person = dao.getDetails();
    	 return "Name:" + person.getName() + "\n" + "Age:" + person.getAge() + "\n"
                + "Height: " + person.getHeight() + "\n" + "Is Programmer?: "
                + person.isProgrammer()+ "\nAddress:"+person.getAddress().getStreetNo()+" "+person.getAddress().getStreetName()+
                " "+person.getAddress().getCity()+" "+person.getAddress().getCountry();
    }
}
