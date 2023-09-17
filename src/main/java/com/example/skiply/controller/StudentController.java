package com.example.skiply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * To add a student
	 * @param student
	 * @return
	 * @throws SkiplyException
	 */
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) throws SkiplyException {

		return studentService.addStudent(student);

	}

}
