package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
    		                    .addAnnotatedClass(Project.class).buildSessionFactory();
       
       Session session = factory.openSession();
       
       try {
    	   Student student = new Student("muzzu");
    	   Project project = new Project("ibm2", false);
    	   
    	   project.setStudent(student);
    	   
    	   session.beginTransaction();
    	   
    	   System.out.println("Saving project: "+ project);
    	   session.save(project);
    	   session.getTransaction().commit();
    	   System.out.println("Done");
    	   
    	   
    	   Project obj = session.find(Project.class, 1L);
    	   System.out.println("Retrieved Project: " + obj);
    	   
       }
       finally
       {
    	   factory.close();
       }
       
    }
}
