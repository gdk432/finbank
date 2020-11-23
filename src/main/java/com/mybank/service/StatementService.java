package com.mybank.service;

import java.util.List;

import com.mybank.dto.TransactionlistResponseDto;

public interface StatementService {

	public List<TransactionlistResponseDto> getTransactions(Long useraccountno);

}
