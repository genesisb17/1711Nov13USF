package com.revature.pojos;

public class Account {
	private int accountId;
	private AccountType accountType;
	private int userId;
	private double balance;
	
	public static AccountType accountTypeFromStr(String at) {
		switch (at) {
		case "checking":
			return AccountType.CHECKING;
		case "savings":
			return AccountType.SAVINGS;
		default:
			return null;
		}
	}
	
	public static String accountTypeFromEnum(AccountType at) {
		switch (at) {
		case CHECKING:
			return "checking";
		case SAVINGS:
			return "savings";
		default:	
			return null;
		}
	}
	
	public Account() {}

	public Account(int accountId, AccountType accountType, int userId, double balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.userId = userId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", accountType=" + accountType + ", userId=" + userId + ", balance="
				+ balance + "]";
	}
	
}
