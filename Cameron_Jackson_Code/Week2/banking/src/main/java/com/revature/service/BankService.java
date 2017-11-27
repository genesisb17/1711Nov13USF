package com.revature.service;

import com.revature.dao.BankDAO;
import com.revature.dao.BankDatabaseDAO;
import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;

public class BankService {
	
	BankDAO dao = new BankDatabaseDAO();
	
	private boolean userExists(String username) {
		User u = dao.getUserByUname(username);
		if (u != null)
			return true;
		
		return false;
	}
	
	private boolean userExists(int user_id)	 {
		User u = dao.getUserById(user_id);
		if(u != null)
			return true;
		
		return false;
	}
	
	public User addUser(String firstname, String lastname, String username, String password) {
		User u = new User();
		// Validate that username is unique before adding user
		if (userExists(username))
			return null;
		
		dao.addUser(firstname, lastname, username, password);
		return u;
	}
	
	public User getUser(String username) {
		User u = new User();
		
		u = dao.getUserByUname(username);
		return u;
	}
	
	// Add update user function
	
	public Account addAccount(AccountType at, int user_id, double balance) {
		Account acc = new Account();
		
		if (!userExists(user_id)) // should never happen
			return null;
		
		acc = dao.addAccount(at, user_id, balance);
		return acc;
	}
	
	public Account getAccount(int acc_id) {
		Account acc = new Account();
		
		acc = dao.getAccount(acc_id);
		return acc;
	}
	
	public Account updateBalance(double balance, int acc_id) {
		Account acc = new Account();
		
		acc = dao.updateAccountBalance(balance, acc_id);
		return acc;
	}
}
