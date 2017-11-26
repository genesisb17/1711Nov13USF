package com.bank.pojos;

public class Accounts {
	private Integer uId;
	private Integer acctId;
	private Double balance;
	
	public Accounts() {

	}
	
	public Accounts(Integer uId, Double balance) {
		super();
		this.uId = uId;
		this.balance = balance;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getAcctId() {
		return acctId;
	}

	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String toFile() {
		return "[" + uId + ", " + acctId + ", " + balance + "]";
		
	}
}
