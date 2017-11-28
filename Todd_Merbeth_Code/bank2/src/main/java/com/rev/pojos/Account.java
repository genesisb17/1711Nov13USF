package com.rev.pojos;

public class Account {
	
	private int acc_id;
	private int user_id;
	private double balance;
	
	public Account() {}
	
	public Account(int acc_id, int user_id, double balance) {
		super();
		this.acc_id = acc_id;
		this.user_id = user_id;
		this.balance = balance;
	}
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account ID = " + acc_id + ", Balance = $" + balance;
	}

}
