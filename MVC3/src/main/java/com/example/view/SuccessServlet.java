package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import com.example.model.Todo;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Todo todo = (Todo) request.getAttribute("todo");
		out.println("TodoID: "+todo.getId()+" TodoName: "+todo.getName()+" CompletedBy: "+todo.getCompletedBy());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
