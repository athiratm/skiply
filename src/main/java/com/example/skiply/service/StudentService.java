package com.example.skiply.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;


@Service
public interface StudentService {
	
	public ResponseEntity<?> addStudent(Student student) throws SkiplyException;
	
	
}
