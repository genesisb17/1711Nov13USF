package com.rev.pojos;

public class Account {
	private int accountId;
	private int userId;
	private double balance;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Account() {
		this.accountId=0;
		this.userId=0;
		this.balance=0;
	}
	
	public Account(int accountId,int userId, double balance) {
		super();
		this.accountId=accountId;
		this.userId=userId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
