package com.rev.pojos;

public class User {
	private int id;
	private String username;
	private String password;
	private String fn;
	private String ln;
	private String email;
	private int role;

	public User() {
		id=0;
		username="";
		password="";
		fn="";
		ln="";
		email="";
		role=0;
	}	
	public User(int id, String username, String password, String fn, String ln, String email, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.role = role;
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
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
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
}
