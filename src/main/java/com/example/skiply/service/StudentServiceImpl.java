package com.example.skiply.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<?> addStudent(Student student) throws SkiplyException {
		try {
			studentRepository.save(student);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			throw new SkiplyException(e.getMessage());
		}
	}

}
