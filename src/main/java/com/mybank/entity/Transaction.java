package com.mybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transaction_id;
	
	private long from_account_number;
	private long to_account_number;
	private long transfer_amount;
	private String user_comment;
	private String trnsactiondate;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public long getFrom_account_number() {
		return from_account_number;
	}
	public void setFrom_account_number(long from_account_number) {
		this.from_account_number = from_account_number;
	}
	public long getTo_account_number() {
		return to_account_number;
	}
	public void setTo_account_number(long to_account_number) {
		this.to_account_number = to_account_number;
	}
	public long getTransfer_amount() {
		return transfer_amount;
	}
	public void setTransfer_amount(long transfer_amount) {
		this.transfer_amount = transfer_amount;
	}
	
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	public String getTrnsactiondate() {
		return trnsactiondate;
	}
	public void setTrnsactiondate(String trnsactiondate) {
		this.trnsactiondate = trnsactiondate;
	}
	
	
	
}
