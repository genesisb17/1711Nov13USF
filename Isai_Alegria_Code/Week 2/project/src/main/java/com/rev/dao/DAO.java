package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	void addUser(User u);
	boolean findUser(String username);
	boolean getUser(String username, String password);
	User getUser(String username);
	void viewBalance(String user);
	void setAccount(User u);
	void deposit(String user, double amount);
	void withdraw(String user, double amount);
	
}
