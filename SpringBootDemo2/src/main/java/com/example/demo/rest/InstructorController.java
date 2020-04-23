package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InstructorDetails;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	private InstructorService service;
	
	@PostMapping("/add")
	public void addInstructor(@RequestBody InstructorDetails instructor)
	{
		service.addInstructor(instructor);
	}
	
	@GetMapping("/getCustomer/{id}")
	public InstructorDetails getInstructor(@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		InstructorDetails obj = service.getInstructor(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			return obj;
	}
	@GetMapping("/getAllCustomer")
	public List<InstructorDetails> getAllInstructor()
	{
		return service.getAllInstructor();
	}
	
	@DeleteMapping("/deleteInstrutor/{id}")
	public void deleteInstructor(@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		InstructorDetails obj = service.getInstructor(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			
		service.deleteInstructor(id);
	}
	
	@PutMapping("/update")
	public void updateInstructor( @RequestBody InstructorDetails instructor)
	{
		service.updateInstructor(instructor);
	}
}

