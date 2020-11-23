package com.mybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mybank.entity.Transaction;

@Repository
public interface TransactionRepoistory extends JpaRepository<Transaction, Integer>{

	@Query("From Transaction transaction where transaction.from_account_number =:useraccountno")
	public List<Transaction> findByfrom_account_number(Long useraccountno);

}
