package com.ex.pojos;

public class Account {
	private int accountId;
	public Account(int accountId, int userId, double balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}
	
	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", userId=" + userId + ", balance=" + balance + "]";
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	private int userId; // only important one
	private double balance;
	

}
