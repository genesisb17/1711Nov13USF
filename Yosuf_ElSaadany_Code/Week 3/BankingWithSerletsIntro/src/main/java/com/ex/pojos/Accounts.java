package com.ex.pojos;

public class Accounts {
	
	private int A_id;
	private int U_id;
	private double balance;
	
	public Accounts() {}

	public Accounts(int a_id, int u_id, double balance) {
		super();
		A_id = a_id;
		U_id = u_id;
		this.balance = balance;
	}

	public int getA_id() {
		return A_id;
	}

	public void setA_id(int a_id) {
		A_id = a_id;
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

	@Override
	public String toString() {
		return "Accounts [A_id=" + A_id + ", U_id=" + U_id + ", balance=" + balance + "]";
	}
}
