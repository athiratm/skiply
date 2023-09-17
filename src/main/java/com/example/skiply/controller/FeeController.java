package com.example.skiply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skiply.entity.Receipt;
import com.example.skiply.exceptions.SkiplyException;
import com.example.skiply.service.FeeService;

@RestController
@RequestMapping("/fee")
public class FeeController {

	@Autowired
	private FeeService feeService;

	/**
	 * To collect fee for a student
	 * 
	 * @param receipt
	 * @return
	 * @throws SkiplyException
	 */
	@PostMapping("/collect")
	public ResponseEntity<?> collectFee(@RequestBody Receipt receipt) throws SkiplyException {
		return feeService.collect(receipt);
	}

}
