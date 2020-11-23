package com.mybank.service;

import com.mybank.dto.TransactionRequestDto;
import com.mybank.dto.TransactionResponseDto;

public interface FundTransferService {

	public TransactionResponseDto transferfund(TransactionRequestDto transactionRequestDto);

}
