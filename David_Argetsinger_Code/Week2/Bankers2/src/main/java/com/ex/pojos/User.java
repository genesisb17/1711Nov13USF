package com.ex.pojos;

public class User {
	private int id;

	public User() {
	};

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", lastname=" + lastname
				+ ", name=" + name + "]";
	}

	public User(int id, String username, String password, String lastname, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.name = name;
	}

	private String username;
	private String password;
	private String lastname;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
