package com.rev.pojos;

/**
 * @author Andy
 *
 */
public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double balance;
	
	
	public User() {}
	
	public User(int id, String firstName, String lastName, String userName, String password, double balance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
		return id + ":" + firstName + ":" + lastName + ":" + userName + ":" + password + ":" + balance;
	}
	
	

	
}
