package com.example.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.example.demo.model.Image;
import com.example.demo.service.ImageServiceImpl;
import com.example.demo.service.ImageServiceInterface;


public class App 
{
	private ImageServiceInterface service; 
	private static Scanner scanner = new Scanner(System.in);
	
	{
		service = new ImageServiceImpl();
	}
	
    public static void main( String[] args ) throws SQLException
    {
    	   int choice = 0;
           App app = new App();
           do {
           	System.out.println("1.Add Image");
           	System.out.println("2.Display Image");
        	System.out.println("3.Display AllImage");
           	System.out.println("4.Delete Image");
           	System.out.println("5.Update Image");
           	System.out.println("choose your choice");
           	choice = scanner.nextInt();
           	switch(choice)
           	{
           	case 1:
           	{
           		System.out.println("enter the imageUrl: ");
           		String imageUrl = scanner.next();
           		System.out.println("enter the isAvailable in boolean: ");
           		boolean isAvailable = scanner.hasNextBoolean();
           		
           		app.service.addImage(new Image(imageUrl,isAvailable));;
           		break;
           	}
           	case 2:
           	{
           		System.out.println("enter the imageUrl: ");
           		String imageUrl = scanner.next();
           		Image imageById = app.service.getImageByImageUrl(imageUrl);
           		System.out.println(imageById);
           		break;
           	}
           	case 3:
           	{
           		
           		List<Image> list = app.service.getAllImage();
           		for(Image image:list)
           		{
           			System.out.println(image);
           		}
           		break;
           	}
           	case 4:
           	{
           		
           		System.out.println("enter the imageUrl to delete: ");
           		String imageUrl = scanner.next();
           		app.service.deleteImage(imageUrl);
           		
           		
           		
           		break;
           	}
           	case 5:
           	{
           		System.out.println("Enter the ImageUrl to update");
           		String oldName = scanner.next();
           		System.out.println("Enter the isAvailable in boolean: ");
           		boolean isAvailable = scanner.hasNextBoolean();
           		
           		app.service.updateImage(oldName, isAvailable);
           	}
           	}
           }while(choice !=0);
           
   
    }
}
