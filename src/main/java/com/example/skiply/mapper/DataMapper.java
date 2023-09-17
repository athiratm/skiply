package com.example.skiply.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.example.skiply.entity.Receipt;
import com.example.skiply.entity.Student;
import com.example.skiply.repository.ReceiptRepository;
import com.example.skiply.repository.StudentRepository;

@Service
public class DataMapper {
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public Context setData(Long studentId) {

		Context context = new Context();
		Student student = null ;
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		if(optionalStudent.isPresent()) {
			student = optionalStudent.get();
		}
		
		Receipt optionalReceipt= receiptRepository.findByStudentId(student.getId());

		Optional<Student> student1 = studentRepository.findById(student.getId());
		System.out.println(student1);
		
		
		Map<String, Object> data = new HashMap<>();

		data.put("receipt", optionalReceipt);
		data.put("student", student1.get());

		context.setVariables(data);

		return context;
	}
	
	
}
