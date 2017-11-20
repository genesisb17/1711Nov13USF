package com.rev.pojos;

public class User {

	private int id;
	private String FirstName;
	private String LastName;
	private String username;
	private String password;
	private double balance;
	public User(){};
	public User(int id, String firstName, String lastName, String username, String password, double balance) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.username = username;
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
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", username=" + username
				+ ", password=" + password + ", balance=" + balance + "] \n";
	}
	public String toFile() {
		return id + ":" + FirstName + ":" + LastName + ":" + username
				+ ":" + password + ":" + balance+ "\n";
	}
	
	// make another one for file writing ;
	
	
	
	
}
