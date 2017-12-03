package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.OracleDAO;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new OracleDAO();
	static ArrayList<User> userList = new ArrayList<User>();
	
	/*
	 * Update the userList with all the names from the text file. This is called when the program is first run
	 * to make sure the data is accurate.
	 */
	public void updateUsernames() { 
		userList = dao.getUsers();
	}
	
	public ArrayList<User> getUsers() { 
		return dao.getUsers();
	}

	/*
	 * For adding a new user to the list
	 */
	public User addUser(User u) {
		// validate that username does not exist
		for (int i = 0; i < userList.size(); i++) { // If the list contains a user with the same username return null
			if (userList.get(i).getUsername().equals(u.getUsername())) {
				return null;
			}
		}
		// assuming that it DNE:
		u = dao.addUser(u);  // Ask the dao to write the user to the file
		
		if (u != null && u.getUsername() != null) {
			userList.add(u);  // Add user to the userList
		}
		return u;
	}
	
	/*
	 * To get a user with a username that matches from the list
	 */
	public User getUser(String username) {
		for (int i = 0; i < userList.size(); i++) { 
			if (userList.get(i).getUsername().equals(username)) {  // if username is that same as the current user on the list
				return userList.get(i);							   // return the user that has that username
			}
		}
		return null;  // If the user isn't on the list return null
	}
	
	/*
	 * Get the all of the given user's accounts
	 */
	public ArrayList<Account> getAccounts(User user){
		return dao.getAccounts(user);
	}
	/*
	 * Get the all of the given user's accounts
	 */
	public Account getAccount(int account){
		return dao.getAccount(account);
	}

	public Account createAccount(User user) {
		return dao.createAccount(user);
	}
	
	/*
	 * Update the balance of the user by the deposit amount
	 */
	public Account updateDeposit(Account account, double dep) {
		return dao.updateDeposit(account, dep);
	}
	
	/*
	 * Update the balance of the user by the withdraw amount
	 */
	public Account updateWithdraw(Account account, double wd) {
		if (account.getBalance() >= wd) { // Check that the account has enough money to make the withdraw
			account = dao.updateWithdraw(account, wd);  // tell DAO to update data
			return account;
		}
		return null;
	}
}
