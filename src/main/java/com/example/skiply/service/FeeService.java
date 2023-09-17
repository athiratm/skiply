package com.example.skiply.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.skiply.entity.Receipt;
import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.repository.ReceiptRepository;
import com.example.skiply.repository.StudentRepository;

@Service
public class FeeService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public ResponseEntity<?> collect(Receipt receipt) throws SkiplyException {
		
		try {
			Optional<Student> optionalStudent = studentRepository.findById(receipt.getStudentId());
			if(optionalStudent.isPresent()) {
				  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm");
				  LocalDateTime localDate = LocalDateTime.now();
				  String currentDateTime = dtf.format(localDate);
				receipt.setDateTime(currentDateTime);
				receipt = receiptRepository.save(receipt);
			}
			Student student = updateStudent(optionalStudent.get(), receipt);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}catch(Exception e) {
			
			throw new SkiplyException(e.getMessage());
		}
		
		
		
	}
	
	/**
	 * To add receipt for student who paid fee
	 * 
	 * @param student
	 * @param receipt
	 * @return
	 */
	private Student updateStudent(Student student, Receipt receipt) {
		
		student.setReceipt(receipt);
		student = studentRepository.save(student);
		return student;
	}

}
