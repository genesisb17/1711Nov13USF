package com.rev.pojos;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private double balance;
	public User() {}
	
	//for temporary storage of a p
	public User (String username) {
		this.username = username;
		
	}
	
	public User(int id, String firstname, String lastname, String username, String password, double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public boolean equals(Object o) {
		return ((o instanceof User) && (this.getId() ==  ((User) o).getId())) ;
	}
	
	public String toFile() {
		return id + ":" + firstname + ":" + lastname + ":" + username
				+ ":" + password + ":" + balance;
	}
	
	

	
}
