package com.rev.pojos;

public class ERSUser {

	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String LastName;
	private String email;
	private int roleID;
	
	public ERSUser() {}
	
	public ERSUser(int userID, String username, String password, String firstName, String lastName, String email,
			int roleID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.roleID = roleID;
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
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public void nullifyUser() {
		this.userID = -1;
		this.username = null;
		this.password = null;
		this.firstName = null;
		this.LastName = null;
		this.email = null;
		this.roleID = -1;
	}

	@Override
	public String toString() {
		return "ERSUser [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", LastName=" + LastName + ", email=" + email + ", roleID=" + roleID + "]";
	}

	
}
