package com.revature.pojos;

public class User {
	private int userId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public User() {}

	public User(int userId, String firstname, String lastname, String username, String password) {
		super();
		this.userId = userId;
		this.firstname = firstname; 
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
	public User(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname; 
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}

}
