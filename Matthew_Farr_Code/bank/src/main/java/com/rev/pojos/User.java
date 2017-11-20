package com.rev.pojos;

import java.math.BigDecimal;

public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private BigDecimal balance;
	
	public User(){}
	
	public User( String firstname, String lastname, String username, String password, BigDecimal balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String toFile() {
		return  firstname + ":" + lastname + ":" + username
				+ ":" + password + ":" + balance;
	}
	
	public String toConsole() {
		return "\nUsername: " + username + "\nFirst Name: " + firstname + "\nLast Name: " + lastname + "\n";
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", balance=" + balance + "]";
	}

}
