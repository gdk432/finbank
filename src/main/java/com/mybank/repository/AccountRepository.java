package com.mybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mybank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query("From Account account where account.account_number =:fromaccount")
	public Account findByaccount_number(long fromaccount);

}
