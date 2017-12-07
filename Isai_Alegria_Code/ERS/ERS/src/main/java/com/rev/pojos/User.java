package com.rev.pojos;

public class User {
	
	public int userID;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public int userRoleID;
	
	
	
	public User(){
		
		userID = 0;
		userRoleID = 99;
	}
	
	public User(int id, String uname, String pass, String fname, String lname, String email, int uRoleID) {
		super();
		this.userID = id;
		this.username = uname;
		this.password = pass;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.userRoleID = uRoleID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	@Override
	public String toString() {
		return "Artist [id=" + userID + ", name=" + firstName + "]";
	}
	
	
	
}
