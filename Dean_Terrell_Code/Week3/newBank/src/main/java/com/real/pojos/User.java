package com.real.pojos;

public class User {

	private int id;
	private String uName;
	private String password;
	private String fName;
	private String lName;
	private int role;
	
	public User() {
	}
	
	public User(int id, String fName, String lName, String uName,
			String password, String email, int role) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
