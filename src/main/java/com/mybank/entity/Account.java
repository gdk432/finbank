package com.mybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int account_id;
	private long account_number;
	private String account_type;
	private long account_opening_balance;
	private long account_current_balance;
	private int account_user_id;
	public int getAccount_id() {
		return account_id;
	}
	
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public long getAccount_opening_balance() {
		return account_opening_balance;
	}
	public void setAccount_opening_balance(long account_opening_balance) {
		this.account_opening_balance = account_opening_balance;
	}
	public long getAccount_current_balance() {
		return account_current_balance;
	}
	public void setAccount_current_balance(long account_current_balance) {
		this.account_current_balance = account_current_balance;
	}
	public int getAccount_user_id() {
		return account_user_id;
	}
	public void setAccount_user_id(int account_user_id) {
		this.account_user_id = account_user_id;
	}
	
	
	
	
}
