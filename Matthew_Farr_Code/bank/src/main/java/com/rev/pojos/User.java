package com.rev.pojos;

import java.math.BigDecimal;

public class User {
	
	private int id;
	private String firstName, lastName, username, password;
	private BigDecimal balance;
	
	public User() {super();}

	public User(int id, String firstName, String lastName, String username, String password, BigDecimal balance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	@Override
	/**
	 * Eclipse provided default implementation for toString(). Used for printing User objects to the console for
	 * testing
	 */
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", balance=" + balance + "]";
	}
	
	/**
	 * @return String representation used for writing to text file storage
	 */
	public String toFileString() {
		return id + ":" + firstName + ":" + lastName + ":" + username + ":" + password + ":" + balance;
	}

	/* Getters and setters for private fields 
	 */
	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getFirstName() {return firstName;}

	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}

	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public BigDecimal getBalance() {return balance;}

	public void setBalance(BigDecimal balance) {this.balance = balance;}
}
