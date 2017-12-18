package com.rev.pojos;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int roleId;
	
	// No arguments constructor
	public User() {
		super();
	}

	// Constructor from fields
	public User(int userId, String username, String password, String firstname, String lastname, String email,
			int roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
	
	/* * * * * * * * * * * * * * * * * *
	 * GETTERS AND SETTERS START HERE  *
	 * * * * * * * * * * * * * * * * * */

	public int getUserId() {return userId;}

	public void setUserId(int userId) {this.userId = userId;}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getFirstname() {return firstname;}

	public void setFirstname(String firstname) {this.firstname = firstname;}

	public String getLastname() {return lastname;}

	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public int getRoleId() {return roleId;}

	public void setRoleId(int roleId) {this.roleId = roleId;}
	
}
