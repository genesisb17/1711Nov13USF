package com.revature.entities;

public class Account {
	private int id;
	private int customerId;
	private double balance;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int id, int custmerId, double balance) {
		super();
		this.id = id;
		this.customerId = custmerId;
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
	public void setCustomerId(int custmerId) {
		this.customerId = custmerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
