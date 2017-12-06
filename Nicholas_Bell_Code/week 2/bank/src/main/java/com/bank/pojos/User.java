package com.bank.pojos;

import java.util.ArrayList;

public class User {
	private int user_id;
	private String Firstname;
	private String Lastname;
	private String Username;
	private String Password;
	protected ArrayList<Account> Accounts = new ArrayList<Account>();
	
	public User() {};
	public User(String firstname, String lastname, String username, String password) {
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Username = username;
		this.Password = password;
	}
	public User(int id, String firstname, String lastname, String username, String password) {
		this.user_id = id;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Username = username;
		this.Password = password;
	}
	
	public User(int id, String firstname, String lastname, String username, String password, ArrayList<Account> accounts) {
		this.user_id = id;
		this.Firstname = firstname;
		this.Lastname = lastname;
		this.Username = username;
		this.Password = password;
		this.Accounts = accounts;
	}

	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public ArrayList<Account> getAccounts() {
		return Accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.Accounts = accounts;
	}
	public void addAccount(Account acc) {
		this.Accounts.add(acc);
	}
	
}
