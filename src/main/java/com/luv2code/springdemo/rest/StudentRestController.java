package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @post constructor to load the student data only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "patel"));
		theStudents.add(new Student("Mario", "rossi"));
		theStudents.add(new Student("Mary", "Karlz"));
	}
	
		
	//define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){	
		return theStudents;
	}
	
	
	//define the endpoint for single student by id 
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//Check the studentId against the list size and return error 
		if(studentId >= theStudents.size() || (studentId < 0 ) ) {
			throw new StudentNotFoundException("Student is not found - "+ studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
}
