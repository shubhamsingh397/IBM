package com.example.demo;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.bean.Image;
import com.example.demo.service.ImageService;
import com.example.demo.service.ImageServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    	//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ImageService imageService=context.getBean("imageServiceImpl",ImageServiceImpl.class); 
		//Image todo=imageService.createImage(new Image(UUID.randomUUID().toString(), "abc.jpg"));
		//System.out.println(todo);
		
		int choice = 0;
		do {
		System.out.println("1.AddImage");
		System.out.println("2.ListAllImage");
		System.out.println("3.UpdateImage");
		System.out.println("4.DeleteImage");
		System.out.println("5.DeleteAll");
		System.out.println("\n choose option");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter the ImageUrl");
			String url = scanner.next();
			Image image = context.getBean("image", Image.class);
			image.setImageId(UUID.randomUUID().toString());
			image.setImageUrl(url);
			imageService.createImage(image);
			break;
			
		}
		case 2:
		{
			List<Image> list = imageService.listImage();
			for (Image img : list)
			{
				System.out.println(img);
			}
			break;
		}
		case 3:
		{
			System.out.println("enter the imageId");
			String id = scanner.next();
			System.out.println("enter the imageUrl");
			String url = scanner.next();
			imageService.updateById(id, url);
			break;
		}
		case 4:
		{
			System.out.println("enter the imageId");
			String id = scanner.next();
			imageService.deleteById(id);
			break;
		}
		case 5:
		{
			imageService.deleteAll();
		}
		
		}
		
		}while(choice!=0);
		
    }
}
