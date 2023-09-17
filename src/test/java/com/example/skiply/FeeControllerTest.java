package com.example.skiply;





import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.skiply.controller.InvoiceController;
import com.example.skiply.entity.Receipt;
import com.example.skiply.entity.Student;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.InvoiceService;

@SpringBootTest
public class FeeControllerTest {

	@Mock
	InvoiceService invoiceService;
	
	@InjectMocks
	InvoiceController invoiceController;
	
	
	@Test
	public void testFeeCollection() throws SkiplyException {
		
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
		when(invoiceService.generateInvoice(1L)).thenReturn("Success");
		String response = invoiceController.generateDocument(1L);
		
		assertNotNull(response);
		
	}

}
