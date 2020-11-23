package com.mybank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.dto.TransactionlistResponseDto;
import com.mybank.entity.Transaction;
import com.mybank.repository.TransactionRepoistory;
import com.mybank.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	TransactionRepoistory transactionRepository;
	@Override
	public List<TransactionlistResponseDto> getTransactions(Long useraccountno) {
		List<Transaction> transactionList = new ArrayList();
		List<TransactionlistResponseDto> transactionlistResponseDtoList = new ArrayList();
		transactionList = transactionRepository.findByfrom_account_number(useraccountno);
		for(Transaction transaction :transactionList) {
			TransactionlistResponseDto transactionlistResponseDto = new TransactionlistResponseDto();
			BeanUtils.copyProperties(transaction, transactionlistResponseDto);
			transactionlistResponseDtoList.add(transactionlistResponseDto);
		}
		return transactionlistResponseDtoList;
	}

}
