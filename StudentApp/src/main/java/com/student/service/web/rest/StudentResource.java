package com.student.service.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.model.Student;
import com.student.service.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentResource {
	
	@Autowired
	private StudentRepository repository;
	
	@GetMapping("/student/getStudentInfo")
	public ResponseEntity<Student> getStudentInfo() {
		
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/student/insert")
	public ResponseEntity<Integer> saveStudentInfo(Student student) {
		
		return new ResponseEntity<>(repository.saveStudent(student), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateStudent(Student student) throws Exception{
		
		repository.update(student);
		return new ResponseEntity<>("Updatation completed successfully",HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteStudent(Student student) throws Exception{
		
		repository.deleteEmpById(student.getFirstName());
		return new ResponseEntity<String>("Deletion completed sussefully ",HttpStatus.OK);
	}

}
