package com.example.skiply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	/**
	 * Generate invoice for the student using studentId
	 * 
	 * @param studentId
	 * @return
	 * @throws SkiplyException
	 */
	@PostMapping(value = "/generate/invoice")
	public String generateDocument(@RequestParam Long studentId) throws SkiplyException {
		
		return invoiceService.generateInvoice(studentId);
		
	}
	
	
}
