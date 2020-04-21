package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> list = null;
	
	@PostConstruct
	public void init()
	{
		list = new ArrayList<>();
		list.add(new Student(1,"shubham",20));
		list.add(new Student(2,"Muzzu",20));
		list.add(new Student(3,"parag",20));
		
	}
	@GetMapping("/allStudents")
	public List<Student> getStudents()
	{
		//System.out.println(list);
		return list;
	}
	@GetMapping("/student/{id}")
	public Student getstudent(@PathVariable("id") int id) throws StudentNotFoundException
	{
		
		
		if ( (id >= list.size()) || (id < 0) ) {			
			throw new StudentNotFoundException("Student id not found - " + id);
		}
		
		return list.get(id);
			
	}
	@PostMapping("/add")
	public void addStudent(@RequestBody Student student)
	{
		list.add(student);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorEntity> handleException(StudentNotFoundException exc){
		StudentErrorEntity error = new StudentErrorEntity(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<StudentErrorEntity>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorEntity> handleException(NumberFormatException exc)
	{
		StudentErrorEntity error = new StudentErrorEntity(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<StudentErrorEntity>(error, HttpStatus.BAD_REQUEST);
	}
}
