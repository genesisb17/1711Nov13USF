package com.bank.pojos;

public class Accounts {
	private Integer uId;
	private Integer acctId;
	private Integer balance;
	
	public Accounts() {

	}
	
	public Accounts(Integer uId, Integer acctId, Integer balance) {
		super();
		this.uId = uId;
		this.acctId = acctId;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
