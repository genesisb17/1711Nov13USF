package com.rev.pojos;

public class User {
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int role;
	private String roleStr;
	
	public User() {}
	
	public User(int id, String username, String password, String firstname, String lastname, String email, int role, String roleStr) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.roleStr = roleStr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRoleStr() {
		return roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", roleStr=" + roleStr + "]";
	}
}
