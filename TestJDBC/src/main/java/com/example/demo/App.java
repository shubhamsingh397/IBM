package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.factory.MyConnectionFactory;


public class App 
{
    public static void main( String[] args )
    {
    	MyConnectionFactory factory,factory1=null;
    	factory=MyConnectionFactory.getConnectionObject();
    	factory1=MyConnectionFactory.getConnectionObject();
    	System.out.println(factory==factory1);
    	try {
			Connection connection=factory.getMyConnection();
			System.out.println(connection);
			Connection connection1=factory.getMyConnection();
			System.out.println(connection1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
}
