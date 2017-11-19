package com.rev.pojos;

import java.text.DecimalFormat;

public class User {

	private int id;
	private String firstName, lastName, email, password;
	private double balance;
	
	public User() {}

	public User(int id, String firstName, String lastName, String email, String password, double balance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", balance=" + balance + "]";
	}

	public String toFileString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return id + ":" + firstName + ":" + lastName + ":" + email + ":" + password + ":" + df.format(balance);
	}
	
	
	
}
