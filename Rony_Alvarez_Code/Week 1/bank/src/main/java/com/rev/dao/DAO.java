package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.User;

public interface DAO {

	User login(String username, String password);
	User registerUser(User u);
	User createAccount(int userId, double initialBalance);
	ArrayList<User> getBalance(int userId);
	User depositMoney(int userId, double balance, double deposit);
	User withdrawMoney(int userId, double balance, double deposit);
	
	User getUserById(int id);
	User getBalanceById(int id);
	
}
