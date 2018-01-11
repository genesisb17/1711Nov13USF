package com.revature.entities;

public class Account {

	private int id;
	private int customerId;
	private double balance;
	
	public Account() {
		super();
	}

	public Account(int id, int customerId, double balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", balance=" + balance + "]";
	}
	
	
}
