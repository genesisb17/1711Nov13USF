package com.rev.pojos;

public class BankAccount {
	
	private int userID;
	private int accountID;
	private double balance;
	
	public BankAccount() {}
	
	public BankAccount(int userID, double balance) {
		super();
		this.userID = userID;
		this.balance = balance;
	}
	
	public BankAccount(int userID, int accountID, double balance) {
		super();
		this.userID = userID;
		this.accountID = accountID;
		this.balance = balance;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [userID=" + userID + ", accountID=" + accountID + ", balance=" + balance 
				+ "]";
	}
	
	

}
