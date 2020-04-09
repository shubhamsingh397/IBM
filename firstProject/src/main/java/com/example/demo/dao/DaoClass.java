package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.model.Todo;

public class DaoClass {

	List<Todo> list = new ArrayList<Todo>();
	
	public void addtodo(Todo todo)
	{
		list.add(todo);
	}
	
	public List<Todo> displayall()
	{
		return list;
	}
	public void updateById(String id,String name)
	{
		Iterator<Todo> itr = list.iterator();
		while(itr.hasNext())
		{
			Todo obj = itr.next();
			if(obj.getTodoId().equals(id))
			{
				obj.setName(name);
			}
		}
	}
	
	public Todo displayById(String id)
	{
		Iterator<Todo> itr = list.iterator();
		while(itr.hasNext())
		{
			Todo obj = itr.next();
			if(obj.getTodoId().equals(id))
			{
				return obj;
			}
		}
		return null;
	}
	
}
