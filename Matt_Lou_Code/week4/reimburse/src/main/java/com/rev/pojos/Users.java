package com.rev.pojos;

public class Users {
	private int users_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int userRoleId;
	
	public Users() {}

	public Users(int users_id, String username, String password, String firstname, String lastname, String email,
			int userRoleId) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userRoleId = userRoleId;
	}

	
	
	public Users(String username, String password, String firstname, String lastname, String email, int userRoleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.userRoleId = userRoleId;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

//	@Override
//	public String toString() {
//		return "Users [users_id=" + users_id + ", username=" + username + ", password=" + password + ", firstname="
//				+ firstname + ", lastname=" + lastname + ", email=" + email + ", userRoleId=" + userRoleId + "]";
//	}
//	
	
	
}
