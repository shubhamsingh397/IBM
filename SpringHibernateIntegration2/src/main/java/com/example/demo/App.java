package com.example.demo;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Event;
import com.example.demo.model.Speaker;
import com.example.demo.service.EventService;
import com.example.demo.service.EventServiceImpl;
import com.example.demo.service.SpeakerService;
import com.example.demo.service.SpeakerServiceImpl;

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
         
         SpeakerService speakerService = context.getBean("speakerServiceImpl",SpeakerServiceImpl.class);
         EventService   eventService = context.getBean("eventServiceImpl",EventServiceImpl.class);
         
         
         int choice = 0;
         do {
        	 System.out.println("1.Menu for Speaker");
        	 System.out.println("2.Menu for Event");
        	 
        	 choice = scanner.nextInt();
        	 switch(choice)
        	 {
        	 case 1:
        	 {
        		 int choice1 = 0;
        	        do {
        	        System.out.println("1. AddSpeaker");
        	        System.out.println("2. Add Event to Speaker");
        	        System.out.println("3. Speaker By Id");
        	        System.out.println("4. List All Speaker");
        	        System.out.println("5. Delete Speaker By Id ");
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
        	        	System.out.println("Enter the isAvailable Status");
        	        	boolean isAvailable = scanner.nextBoolean();
        	        	Speaker ob = speakerService.addSpeaker(new Speaker(name,email,isAvailable));
        	        	System.out.println("Added Successfully" + ob);
        	        	break;
        	        	
        	        	
        	        }
        	        case 2:
        	        {
        	        	
        	        	System.out.println("Enter the Speaker id");
        	          	long sid = scanner.nextLong();
        	          	System.out.println("Enter the event id");
        	          	long eid = scanner.nextLong();
        	          	Speaker ob1 = speakerService.getSpeaker(sid);
        	          	Event ob2 = eventService.getEvent(eid);
        	          	ob2.setSpeaker(ob1);
        	          	ob1.addEvent(ob2);
        	          	eventService.addEvent(ob2);
        	          	break;
        	        	
        	        }
        	        case 3:
        	        {
        	        	System.out.println("Enter the id");
        	        	long id = scanner.nextLong();
        	        	System.out.println(speakerService.getSpeaker(id));
        	        	break;
        	        }
        	        case 4:
        	        {
        	        	List<Speaker> list = speakerService.getAllSpeaker();
        	        	for(Speaker obj4 : list)
        	        	{
        	        		System.out.println(obj4);
        	        	}
        	        	break;
        	        	
        	        }
        	        case 5:
        	        {
        	        	System.out.println("Enter the id");
        	        	long id = scanner.nextLong();
        	        	speakerService.deleteSpeaker(id);
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
     	        System.out.println("1. AddEvent");
     	        System.out.println("2. Add Speaker to Event");
     	        System.out.println("3. Event By Id");
     	        System.out.println("4. List All Event");
     	        System.out.println("5. Delete Event By Id ");
     	        System.out.println("Enter the choice: ");
     	        choice2 = scanner.nextInt();
     	        
     	        switch(choice2)
     	        {
     	        case 1:
     	        {
     	        	System.out.println("Enter the name");
     	        	String name = scanner.next();
					/*
					 * System.out.println("Enter the date"); Date date = scanner.
					 */
     	        	Event ob = eventService.addEvent(new Event(name,new Date(2020-04-16),new Time(System.currentTimeMillis())));
     	        	System.out.println("Added Successfully" + ob);
     	        	break;
     	        	
     	        	
     	        }
     	        case 2:
     	        {
     	        	
     	        	System.out.println("Enter the Event id");
     	          	long eid = scanner.nextLong();
     	          	System.out.println("Enter the Speaker id");
     	          	long sid = scanner.nextLong();
     	          	Speaker ob1 = speakerService.getSpeaker(sid);
     	          	Event ob2 = eventService.getEvent(eid);
     	          //	ob1.addEvent(ob2);
     	          	ob2.setSpeaker(ob1);
     	          	
     	          	eventService.addEvent(ob2);
     	          	break;
     	        	
     	        }
     	        case 3:
     	        {
     	        	System.out.println("Enter the id");
     	        	long id = scanner.nextLong();
     	        	System.out.println(eventService.getEvent(id));
     	        	break;
     	        }
     	        case 4:
     	        {
     	        	List<Event> list = eventService.getAllEvent();
     	        	for(Event obj3 : list)
     	        	{
     	        		System.out.println(obj3);
     	        	}
     	        	break;
     	        	
     	        }
     	        case 5:
     	        {
     	        	System.out.println("Enter the id");
     	        	long id = scanner.nextLong();
     	        	eventService.deleteEvent(id);
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
