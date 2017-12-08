package com.real.pojos;

public class User {

	private int id;
	private String fName;
	private String lName;
	private String uName;
	private String password;
	private double balance;
	
	public User() {
	}
	
	public User(int id, String fName, String lName, String uName,
			String password, double balance) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
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
		return id + ":" + fName + ":" + lName
				+ ":" + uName + ":" + password + ":"
				+ balance + "\n";
	}
	
	
	
	
}
