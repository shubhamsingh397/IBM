package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Task;
import com.example.demo.model.Todo;

public class TodoDaoImpl implements TodoDao {

	private Task task;
	{
		task = new Task();
	}
	public void createTask(Todo todo) {
		
		task.createTodo(todo);
		
	}

	public List<Todo> getAllTodo() {
		
		return task.getAllTodo();
	}

	public void delete(String name) {
		// TODO Auto-generated method stub
		task.delete(name);
	}

	public void update(String oldname,String newName) {
		// TODO Auto-generated method stub
		task.update(oldname, newName);
	}

}
