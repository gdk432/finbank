package com.mybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.dto.TransactionRequestDto;
import com.mybank.dto.TransactionResponseDto;
import com.mybank.exception.TransactionException;
import com.mybank.service.FundTransferService;

@RestController
@RequestMapping("/fundtransfer")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;

	@Autowired
	Environment enviroment;

	@GetMapping("/port")
	public String getInfo() {
		String port = enviroment.getProperty("local.server.port");
		return "From Server" + port;
	}

	@PostMapping("/newtransaction")
	public TransactionResponseDto transferfund(@RequestBody TransactionRequestDto transactionRequestDto) {
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		transactionResponseDto = fundTransferService.transferfund(transactionRequestDto);
		if (transactionResponseDto.getMessage() != "sucess") {
			throw new TransactionException("Transaction not completed");
		}
		return transactionResponseDto;
	}
}
