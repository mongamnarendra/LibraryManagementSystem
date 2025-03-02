package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PostMapping("/login/{email}/{password}")
	public String login(@PathVariable String email,@PathVariable String password) {
		
		return studentService.login(email, password);
	}
	
	
	@GetMapping("/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentService.getByEmail(email);
	}
	
	
}
