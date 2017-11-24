package com.rev.pojos;

public class User {
	
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private double balance;
	
	public User(String fname, String lname, String username, String password) {
		super();
		//this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.balance = 0;
	}
	
	public User(int id, String fname, String lname, String username, String password, double balance) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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
	
	public String toFile() {
		return id + ":" + fname.toLowerCase() + ":" + lname.toLowerCase() + ":" + username + ":"
				+ password + ":" + balance + "\n";
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname 
				+ ", username=" + username + ", password=" + password 
				+ ", balance=" + balance + "]" + "\n";
	}
	
	
}
