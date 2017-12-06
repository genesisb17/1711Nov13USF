package com.bank.pojos;

import java.text.DecimalFormat;

public class Account {
	private int AccId;
	private int UserId;
	private double Balance;
	
	public Account() {};
	
	
	public int getAccId() {
		return AccId;
	}
	public void setAccId(int accId) {
		AccId = accId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public double getBalance() {
		return Balance;
	}
	public String getFormatedBalance() {
		DecimalFormat df = new DecimalFormat("#0.00");
		String num = df.format(Balance);
		return num;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account no: " + this.getAccId() + " Balance: $" + this.getFormatedBalance();
	}
 
	
}
