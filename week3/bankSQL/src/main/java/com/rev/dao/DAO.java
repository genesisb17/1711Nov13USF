package com.rev.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public interface DAO {
	void addNewUser(String first, String last, String user, String pass);
	void addNewAccount(int userId,double balance);
	Account getAccountById(int id);
	User getUserById(int id);
	double updateBalance(double amountChange,Account acc);
	ArrayList<User> getUsers();
	ArrayList<Account> getAccountsByUser(int userId, Connection c);
	User getUserByUsername(String username);
	
}
