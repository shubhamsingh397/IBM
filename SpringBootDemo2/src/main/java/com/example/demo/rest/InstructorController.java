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

import com.example.demo.model.Instructor;
import com.example.demo.service.InstructorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/instructor")
@Api(value="Instructor Management System", description="Operations pertaining to Instructor in Instructor Management System")
public class InstructorController {

	@Autowired
	private InstructorService service;
	
	@ApiOperation(value = "Add an Instructor with InstructorDetails")
	@PostMapping("/add")
	public void addInstructor(@ApiParam(value = "Instructor with nested InstructorDetails object store in database table", required = true)@RequestBody Instructor instructor)
	{
		service.addInstructor(instructor);
	}
	
	@ApiOperation(value = "Get an Instructor with InstructorDetails by Id")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/getInstructor/{id}")
	public Instructor getInstructor(@ApiParam(value = "Instructor id from which instructor object will retrieve", required = true)@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		Instructor obj = service.getInstructor(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			return obj;
	}
	@ApiOperation(value = "View a list of available Instructor with Instructor_Details", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/getAllInstructor")
	public List<Instructor> getAllInstructor()
	{
		return service.getAllInstructor();
	}
	@ApiOperation(value = "Delete an Instructor")
	@DeleteMapping("/deleteInstructor/{id}")
	public void deleteInstructor(@ApiParam(value = "Instructor Id from which instructor object will delete from database table", required = true)@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		Instructor obj = service.getInstructor(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			
		service.deleteInstructor(id);
	}
	@ApiOperation(value = "Update an Instructor")
	@PutMapping("/update")
	public void updateInstructor(@ApiParam(value = "Instructor with nested Instructor_Details Object to update Instructor object", required = true) @RequestBody Instructor instructor)
	{
		service.updateInstructor(instructor);
	}
}

