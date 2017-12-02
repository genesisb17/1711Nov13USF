package com.ex.pojos;

public class Users {
	
	private int U_id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public Users() {}

	public Users(int U_id, String firstname, String lastname, String username, String password) {
		super();
		this.U_id = U_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public int getU_id() {
		return U_id;
	}

	public void setU_id(int U_id) {
		this.U_id = U_id;
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
		return "Users [U_id=" + U_id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}

}
