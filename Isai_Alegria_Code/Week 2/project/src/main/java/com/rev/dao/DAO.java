package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	void addUser(User u);
	boolean findUser(String username);
	boolean getUser(String username, String password);
	User getUser(String username);
	void viewBalance(User u);
	void setAccount(User u);
	void deposit(User u, double amount,int acc);
	void withdraw(User u, double amount,int acc);
	void createAnotherAccount(User u);
	
}
