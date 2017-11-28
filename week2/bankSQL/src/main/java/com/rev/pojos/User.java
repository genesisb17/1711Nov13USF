package com.rev.pojos;

import java.util.ArrayList;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private ArrayList<Account> accounts;
	
	public User() {
		this.firstname="";
		this.lastname="";
		this.username="";
		this.password="";
		this.accounts=new ArrayList<>();
	}
	
	public User(int id, String firstname, String lastname, String username, String password,ArrayList<Account> accounts) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
}
