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
import com.example.demo.service.InstructorDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/instructorDetails")
@Api(value="Instructor Management System", description="Operations pertaining to InstructorDetails in Instructor Management System")
public class InstructorDetailsController {

	@Autowired
	private InstructorDetailsService service;
	@ApiOperation(value = "Add an InstructorDetails With Instructor")
	@PostMapping("/add")
	public void addInstructor(@ApiParam(value = "InstructorDetails with nested Instructor object store in database table", required = true)@RequestBody InstructorDetails instructor)
	{
		service.addInstructorDetails(instructor);
	}
	
	@ApiOperation(value = "Get an InstructorDetails by Id")
	
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/getInstructor/{id}")
	public InstructorDetails getInstructor(@ApiParam(value = "InstructorDetails id from which instructorDetails object will retrieve", required = true)@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		InstructorDetails obj = service.getInstructorDetails(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			return obj;
	}
	@ApiOperation(value = "View a list of available Instructor_Details", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/getAllInstructor")
	public List<InstructorDetails> getAllInstructor()
	{
		return service.getAllInstructorDetails();
	}
	@ApiOperation(value = "Delete the InstructorDetails object as well as Instructor object")
	@DeleteMapping("/deleteInstructor/{id}")
	public void deleteInstructor(@ApiParam(value = "InstructorDetails Id from which instructordetails and instructor object will delete from database table", required = true)@PathVariable("id")int id) throws InstuctorNotFoundException
	{
		InstructorDetails obj = service.getInstructorDetails(id);
		if(obj==null)
			throw new InstuctorNotFoundException("Instructor not found with id: "+id);
		else
			
		service.deleteInstructorDetails(id);
	}
	@ApiOperation(value = "Update an InstructorDetails as well as Instructor")
	@PutMapping("/update")
	public void updateInstructor(@ApiParam(value = "Instructor with nested Instructor_Details Object to update Instructor object", required = true) @RequestBody InstructorDetails instructor)
	{
		service.updateInstructorDetails(instructor);
	}
}

