package com.example.demo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Task {

	public String taskId;

	public ArrayList<Todo> list;
	
	{
		taskId = UUID.randomUUID().toString();
		list = new ArrayList<Todo>();
	}

	public void createTodo(Todo todo) {
		list.add(todo);
		System.out.println("todoAdded Successfully");
	}
	
	public List<Todo> getAllTodo()
	{
		return list;
	}
	
	public void delete(String name)
	{
		Iterator<Todo> itr = list.iterator();
		while(itr.hasNext())
		{
			Todo obj = itr.next();
			if(obj.getName().equals(name))
			{
				list.remove(obj);
				System.out.println(name+" removed successfully");
				return;
			}
		}
		System.out.println(name+" not present in the list");
	}
	public void update(String oldname,String newName)
	{
		Iterator<Todo> itr = list.iterator();
		while(itr.hasNext())
		{
			Todo obj = itr.next();
			if(obj.getName().equals(oldname))
			{
				obj.setName(newName);
				System.out.println(newName+" updated successfully");
			}
		}
		System.out.println(newName+" not present in the list");
	}
}
