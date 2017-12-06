package com.ex.pojos;

public class User {
	
	private String username;
	private String Password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", Password=" + Password + "]";
	}
	
}
