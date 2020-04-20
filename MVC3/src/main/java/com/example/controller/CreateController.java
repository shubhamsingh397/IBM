package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.factory.MyConnectionFactory;
import com.example.model.Todo;


public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       List<String> errors;
       MyConnectionFactory factory=MyConnectionFactory.getConnectionObject();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		errors = new ArrayList<String>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = 0;
		try {
			 id = Integer.parseInt(request.getParameter("todoID"));
		}catch (Exception e) {
			errors.add("TodoID must be numeric");
		}
		String name = request.getParameter("todoName");
		if(name.length()<8)
		{
			errors.add("Name must be 8 characters long");
		}
		String completedBy = request.getParameter("completedBy");
		if(completedBy.length()<=0)
		{
			errors.add("completedBy cannot be left blank");
		}
		
		if(errors.isEmpty())
		{
			Todo todo = new Todo(id,name,completedBy);
			try {
				PreparedStatement prepareStatement = factory.getMyConnection().prepareStatement("insert into todo values (?,?,? )");
				prepareStatement.setInt(1, todo.getId());
				prepareStatement.setString(2,todo.getName());
				prepareStatement.setString(3, todo.getCompletedBy());
				prepareStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("todo", todo);
			RequestDispatcher view = request.getRequestDispatcher("success.jsp");
			view.forward(request, response);
			
		}
		else
		{
			request.setAttribute("errors",errors);
			RequestDispatcher view = request.getRequestDispatcher("error.jsp");
			view.forward(request, response);
		}
		
	}

}
