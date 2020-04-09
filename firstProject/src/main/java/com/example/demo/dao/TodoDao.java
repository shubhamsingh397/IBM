package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Todo;

public interface TodoDao {

	public void createTask(Todo todo);
	public List<Todo> getAllTodo();
	public void delete(String name);
	public void update(String oldname,String newName);
	
}
