package com.rev.pojos;

public class User {
	private int id, role;
	private String username, password, email, fname, lname;

	public static final int ROLE_EMPLOYEE = 1;
	public static final int ROLE_MANAGER = 2;

	public User() {
	}

	public User(int role, String username, String password, String email, String fname, String lname) {
		this(0, role, username, password, email, fname, lname);
	}

	public User(int id, int role, String username, String password, String email, String fname, String lname) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
