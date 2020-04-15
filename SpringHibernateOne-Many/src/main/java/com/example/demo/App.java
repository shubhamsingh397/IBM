package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.openSession();

		try {

			
			  Instructor instructor = new Instructor("abcd","abcd@gmail.com"); Course
			  course1 = new Course("Maths"); Course course2 = new Course("Biology");
			  session.getTransaction().begin(); System.out.println("Saving Courses");
			  session.save(course1); session.save(course2); Course obj1 =
			  session.get(Course.class, 1); Course obj2 = session.get(Course.class, 2);
			  
			  obj1.setInstructor(instructor); obj2.setInstructor(instructor);
			  instructor.add(course1);
			  instructor.add(course2);
				/*
				 * instructor1.add(course1);
				 * 
				 * instructor1.add(course2);
				 */
			  
			  
			  
			  
			  System.out.println("Adding Courses"); session.save(course1);
			  session.save(course2);
			  
			  System.out.println("Adding Instructor"); session.save(instructor);
			  session.getTransaction().commit(); System.out.println("done");
			  
			 
			System.out.println("Details: " + session.get(Instructor.class, 1));

		} finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}
}
