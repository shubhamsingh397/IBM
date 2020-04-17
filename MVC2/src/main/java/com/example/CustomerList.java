package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;

/**
 * Servlet implementation class CustomerList
 */
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Customer> list=null;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
 		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Customer>();
		list.add(new Customer(UUID.randomUUID().toString(),"Shubham","shubham@gmail.com",false));
		list.add(new Customer(UUID.randomUUID().toString(),"Muzzu","muzzu@gmail.com",true));
		list.add(new Customer(UUID.randomUUID().toString(),"Parag","parag@gmail.com",true));
		out.println("<html><head><title>List of Customer</title></head><body><table border = '1'><tr><td>CustomerId</td>"
				+ "<td>CustomerName</td><td>CustomerEmail</td><td>isActive</td></tr>");
		
		for(Customer obj :list)
		{
			out.println("<tr><td>"+obj.getCustomerId()+"</td><td>"+obj.getCustomerName()+"</td><td>"+obj.getCustomerEmail()+
					"</td><td>"+obj.isActive()+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
}
