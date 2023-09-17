package com.example.skiply;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.skiply.controller.FeeController;
import com.example.skiply.entity.Receipt;
import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.FeeService;

@SpringBootTest
public class InvoiceControllerTest {

	@Mock
	FeeService feeService;
	
	@InjectMocks
	FeeController feeController;
	
	
	@Test
	public void testInvoice() throws SkiplyException {
		
		Student testStudent = new Student();
		testStudent.setId(1L);
		testStudent.setStudentName("Athira TM");
		testStudent.setSchoolName("ABC School");
		testStudent.setStudentGrade("2");
		testStudent.setMobile("0788888898");
		
		Receipt receipt = new Receipt();
		receipt.setId(1L);
		receipt.setFee(2000L);
		receipt.setStudentId(1L);
		testStudent.setReceipt(receipt);
		
		ResponseEntity serviceResponse = new ResponseEntity<Student>(testStudent, HttpStatus.OK);
		when(feeService.collect(receipt)).thenReturn(serviceResponse);
		ResponseEntity<?> response = feeController.collectFee(receipt);
		Student student = (Student)response.getBody();
		assertEquals(2000L,student.getReceipt().getFee());
		
	}

}
