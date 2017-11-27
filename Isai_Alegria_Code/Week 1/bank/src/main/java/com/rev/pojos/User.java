package com.rev.pojos;

public class User {
	
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private double balance;
	
	public User() {}
	
	public User(int id, String userName, String firstName, String lastName, String password, double balance) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toFile() {
		
		return id + ":" + userName + ":" + firstName + ":" + lastName + ":" + password + ":" + balance;
	}
	
	
}
