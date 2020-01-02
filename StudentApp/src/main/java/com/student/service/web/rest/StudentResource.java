package com.student.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.model.Student;
import com.student.service.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentResource {
	
	@Autowired
	private StudentRepository repository;
	
	@GetMapping("/getStudentInfo")
	public ResponseEntity<Student> getStudentInfo() {
		
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}

}
