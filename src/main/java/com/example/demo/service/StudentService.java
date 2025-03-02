package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}
	
	
	public String login(String email,String password) {
		Student  student = repo.findByEmail(email);
		if(student!=null && student.getPassword().equals(password)) {
			return "success";
		}
		return "failed";
	}
	
	public Student getByEmail(String email) {
		return repo.findByEmail(email);
	}
}
