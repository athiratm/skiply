package com.example.skiply;





import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.skiply.controller.StudentController;
import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.StudentServiceImpl;

@SpringBootTest
public class StudentControllerTest {

	@Mock
	StudentServiceImpl studentService;
	
	@InjectMocks
	StudentController studentController;
	
	
	@Test
	public void testAddStudent() throws SkiplyException {
		
		Student testStudent = new Student();
		testStudent.setStudentName("Athira TM");
		testStudent.setSchoolName("ABC School");
		testStudent.setStudentGrade("2");
		testStudent.setMobile("0788888898");
		ResponseEntity serviceResponse = new ResponseEntity<Student>(testStudent, HttpStatus.OK);
		when(studentService.addStudent(testStudent)).thenReturn(serviceResponse);
		ResponseEntity<?> response = studentController.addStudent(testStudent);
		Student student = (Student)response.getBody();
		assertEquals("Athira TM",student.getStudentName());
		
	}

}
