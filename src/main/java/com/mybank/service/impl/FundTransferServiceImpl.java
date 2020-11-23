package com.mybank.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybank.dto.TransactionRequestDto;
import com.mybank.dto.TransactionResponseDto;
import com.mybank.entity.Account;
import com.mybank.entity.Transaction;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.TransactionRepoistory;
import com.mybank.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepoistory transactionRepository;
	
	@Override
	@Transactional
	public TransactionResponseDto transferfund(TransactionRequestDto transactionRequestDto) {
		
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		long fromaccountnumber = transactionRequestDto.getFrom_account_number();
		long toaccountnumber = transactionRequestDto.getTo_account_number();
		long trnasferamount = transactionRequestDto.getTransfer_amount();
		String usercomment = transactionRequestDto.getUser_comment();
		this.debitfromAccount(fromaccountnumber, trnasferamount);
		this.credittoAccount(toaccountnumber, trnasferamount);
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionRequestDto, transaction);
		transaction.setTrnsactiondate("10-20-2020 : 5.15 AM");
		((CrudRepository<Transaction, Integer>) transactionRepository).save(transaction);
		transactionResponseDto.setMessage("failed");
		transactionResponseDto.setTransaction_id(678749);
		return transactionResponseDto;
	}
	
	public void debitfromAccount(long fromaccount, long transferfund) {
	Account debitaccount = new Account();
	long before_transfer; 
	long current_balance;
	debitaccount = accountRepository.findByaccount_number(fromaccount);
	if(transferfund!=0) {
		before_transfer = debitaccount.getAccount_current_balance();
		current_balance = (before_transfer - transferfund);
		debitaccount.setAccount_current_balance(current_balance);
	}
	
	accountRepository.save(debitaccount);
		
	}
	
	public void credittoAccount(long toaccount, long transferfund) {
		Account creditaccount = new Account();
		long aftertransfer;
		long current_balance;
		creditaccount = accountRepository.findByaccount_number(toaccount);
		if(transferfund!=0) {
			current_balance = creditaccount.getAccount_current_balance();
			aftertransfer = (current_balance + transferfund);
			creditaccount.setAccount_current_balance(aftertransfer);
		}
		
		accountRepository.save(creditaccount);
	}

}
