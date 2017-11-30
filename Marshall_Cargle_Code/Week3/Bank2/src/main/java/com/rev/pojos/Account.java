package com.rev.pojos;

public class Account {
	private int id;
	private int U_id;
	private double balance;

	public Account() {
	}

	public Account(int id, int u_id, double balance) {
		super();
		this.id = id;
		U_id = u_id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getU_id() {
		return U_id;
	}

	public void setU_id(int u_id) {
		U_id = u_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
