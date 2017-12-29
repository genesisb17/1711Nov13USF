package com.rev.pojos;

public class User {

	private String firstName, lastName, userName, passWord;
	private double balance;

	public User() {
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.passWord = null;
		this.balance = 0.0d;
	}

	public User(String firstName, String lastName, String userName, String passWord, double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return this.getFirstName() + "," + this.getLastName() + "," + this.getUserName() + "," + this.getPassWord() + "," + this.getBalance() + "\n";
	}

	public String toFile() {
		return this.getFirstName() + "," + this.getLastName() + "," + this.getUserName() + "," + this.getPassWord() + "," + this.getBalance() + "\n";
	}

}
