package com.springBoot.BlogApplication.springbootblogApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.BlogApplication.springbootblogApplication.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studService;
	
	
	@PostMapping
	public ResponseEntity<String> createPost(){
		return  new ResponseEntity<>(studService.addStudent(),HttpStatus.CREATED);
	}
	
}
