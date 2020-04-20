package com.example.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		Student student = new Student();
		model.addAttribute(student);
		return "student_form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student,Model model)
	{
		student.setId(UUID.randomUUID().toString());
		model.addAttribute("student", student);
		return "student_confirm";
	}
}
