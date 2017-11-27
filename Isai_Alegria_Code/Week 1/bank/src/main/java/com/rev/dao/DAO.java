package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	
	User addUser(User u);
	boolean getUser(String username, String password);
	double deposit(double amount,String user);
	void viewBalance();
	void withdraw(double amount,String user);
	boolean findUser(String username);

}
