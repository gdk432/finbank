package com.mybank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.dto.TransactionlistResponseDto;
import com.mybank.service.StatementService;

@RestController
@RequestMapping("/transactions")
public class StatementController {

	@Autowired
	StatementService statementService;
	
	@GetMapping("/transactionhistory")
	public List<TransactionlistResponseDto> transferfund(@RequestParam Long useraccountno){
		List<TransactionlistResponseDto> transactionlistResponseDto = new ArrayList();
		transactionlistResponseDto = statementService.getTransactions(useraccountno);
		 return transactionlistResponseDto;
	}
}
