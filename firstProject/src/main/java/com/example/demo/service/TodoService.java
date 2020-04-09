package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Todo;

public interface TodoService {

	public void createTask(Todo todo);
	public List<Todo> getAllTodo();
	public void delete(String name);
	public void update(String oldName,String newName);
}
