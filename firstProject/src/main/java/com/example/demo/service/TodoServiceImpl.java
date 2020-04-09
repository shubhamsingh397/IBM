package com.example.demo.service;
import java.util.List;

import com.example.demo.dao.TodoDao;
import com.example.demo.dao.TodoDaoImpl;
import com.example.demo.model.Todo;
public class TodoServiceImpl implements TodoService {

	private TodoDao dao;
	{
		dao = new TodoDaoImpl();
	}
	public void createTask(Todo todo) {
		// TODO Auto-generated method stub
		dao.createTask(todo);
	}

	public List<Todo> getAllTodo() {
		// TODO Auto-generated method stub
		return dao.getAllTodo();
	}

	public void delete(String name) {
		// TODO Auto-generated method stub
		dao.delete(name);
	}

	public void update(String oldname,String newName) {
		// TODO Auto-generated method stub
		dao.update(oldname, newName);;
	}

 	
}
