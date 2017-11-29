package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.BankDAO;
import com.revature.dao.BankDatabaseDAO;
import com.revature.pojos.Account;
import com.revature.pojos.User;

public class BankService {

	BankDAO dao = new BankDatabaseDAO();

	private boolean userExists(String username) {
		User u = dao.getUserByUname(username);
		if (u.getUsername() != null) 
			return true;
		
		return false;
	}

	private boolean userExists(int user_id)	 {
		User u = dao.getUserById(user_id);
		if(u.getUsername() != null)
			return true;

		return false;
	}

	public User login(String username, String password) {
		// verify that username and password are correct
		if (userExists(username)) {
			User u = dao.getUserByUname(username);
			if (u.getPassword().equals(password)) {
				return u;
			}
		}
		
		return null;
	}

	public User addUser(User u) {
		// Validate that username is unique before adding user
		if (userExists(u.getUsername())) {
			return null;
		}

		dao.addUser(u);
		return u;
	}

	public User getUser(String username) {
		User u = new User();

		u = dao.getUserByUname(username);
		return u;
	}

	public User updatePassword(String newVal, int id) {
		if (!userExists(id))
			return null;
		
		return dao.updatePassword(newVal, id);
	}

	public Account addAccount(Account acc) {

		if (!userExists(acc.getUserId())) // should never happen
			return null;

		acc = dao.addAccount(acc);
		return acc;
	}

	public Account getAccount(int acc_id) {
		return dao.getAccount(acc_id);
	}
	
	public double getBalance(int acc_id) {
		Account acc = dao.getAccount(acc_id);
		
		return acc.getBalance();
	}
	
	public ArrayList<Account> getUserAccounts(User u) {		
		if (!userExists(u.getUserId()))
			return null;
		
		return dao.getUserAccounts(u);
	}

	public Account updateBalance(double balance, int acc_id) {
		Account acc = new Account();
		acc = dao.updateAccountBalance(balance, acc_id);
//		System.out.println("In service.updateBalance: " + acc.getBalance());
		return acc;
	}

}
