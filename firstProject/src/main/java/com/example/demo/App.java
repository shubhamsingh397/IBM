package com.example.demo;

import java.util.List;
import java.util.Scanner;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import com.example.demo.service.TodoServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private TodoService service;
	private static Scanner scanner = new Scanner(System.in);
	{
		service = new TodoServiceImpl();
	}
    public static void main( String[] args )
    {
        int choice = 0;
        App app = new App();
        do {
        	System.out.println("1.Create Task");
        	System.out.println("2.Display Task");
        	System.out.println("3.Delete Task");
        	System.out.println("4.Update Task");
        	System.out.println("choose your choice");
        	choice = scanner.nextInt();
        	switch(choice)
        	{
        	case 1:
        	{
        		System.out.println("enter the todo name: ");
        		app.service.createTask(new Todo(scanner.next()));
        		break;
        	}
        	case 2:
        	{
        		List<Todo> list = app.service.getAllTodo();
        		for(Todo todo:list)
        		{
        			System.out.println(todo);
        		}
        		break;
        	}
        	case 3:
        	{
        		System.out.println("Enter the name to delete");
        		String name = scanner.next();
        		app.service.delete(name);
        		break;
        	}
        	case 4:
        	{
        		System.out.println("Enter the name to update");
        		String oldName = scanner.next();
        		System.out.println("Enter the new name to update");
        		String newName = scanner.next();
        		
        		app.service.update(oldName, newName);
        		break;
        	}
        	}
        }while(choice !=0);
        
        
    }
}
