package com.ERS.pojos;

public class User implements Cloneable{
	private Integer user_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Enum<USER_ROLE> role;
	
	public User() 
	{
		user_id = null;
	};
	
	public User(User u) {
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.firstname = u.getFirstname();
		this.lastname = u.getLastname();
		this.email = u.getEmail();
		this.user_id = u.getUser_id();
	}
	
	public User(int user_id, String username, String firstname, String lastname, String email, Enum<USER_ROLE> role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Enum<USER_ROLE> getRole() {
		return role;
	}
	public void setRole(Enum<USER_ROLE> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", role=" + role + "]";
	}
	

}
