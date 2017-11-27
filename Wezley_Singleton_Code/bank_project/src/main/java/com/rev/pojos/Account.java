package com.rev.pojos;

public class Account {

	private int acctId;
	private String acctType;
	private double balance;
	
	public Account() { }
	
	/**
	 * @param acctId
	 * @param balance
	 */
	public Account(int acctId, String acctType, double balance) {
		super();
		this.acctId = acctId;
		this.acctType = acctType;
		this.balance = balance;
	}

	/**
	 * @return the acctId
	 */
	public int getAcctId() {
		return acctId;
	}

	/**
	 * @param acctId the acctId to set
	 */
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	/**
	 * @return the acctType
	 */
	public String getAcctType() {
		return acctType;
	}
	
	/**
	 * @param acctType the acctType to set
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		
		return "+--------------------------------------------------+" + 
				"\nAccount id: " + this.getAcctId() + "\nAccount type: " + this.getAcctType() + "\nAccount balance: " + this.getBalance() +
				"\n+--------------------------------------------------+";
		
	}
	
}
