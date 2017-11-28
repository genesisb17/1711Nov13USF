package com.rev.pojos;

import java.math.BigDecimal;

public class Account {
	
	private int accountId;
	private int userId;
	private BigDecimal balance;
	
	public Account() {
		super();
	}

	// Constructor using fields
	public Account(int accountId, int userId, BigDecimal balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}
	
	/*
	 * No id constructor
	 * Used when creating an account object to insert into the accounts table, before the auto-generated
	 * id is created
	 */
	public Account(int userId, BigDecimal balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}
	
	@Override
	/**
	 * toString method for outputting the contents of Account object to the console
	 */
	public String toString() {
		return "Account [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + "]";
	}

	/*
	 * Getters and setters for private fields
	 */
	public int getAccountId() {return accountId;}

	public void setAccountId(int accountId) {this.accountId = accountId;}

	public int getUserId() {return userId;}

	public void setUserId(int userId) {this.userId = userId;}

	public BigDecimal getBalance() {return balance;}

	public void setBalance(BigDecimal balance) {this.balance = balance;}

}
