package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;

public interface BankDAO {
	// USER RELATED DAO FUNCTIONS
	// Get user (by username)
	public User getUserByUname(String username);
	// Get user (by ID)
	public User getUserById(int id);
	// Get all users
	public ArrayList<User> getAllUsers();
	// Add user
	public User addUser(String firstname, String lastname, String username, String password);
	// Update user
	public User updateFirstName(String newVal, int id);
	public User updateLastName(String newVal, int id);
	public User updateUsername(String newVal, int id);
	public User updatePassword(String newVal, int id);
	
	// ACCOUNT RELATED DAO FUNCTIONS
	// Get account (by ID)
	public Account getAccount(int id);
	// Get all accounts
	public ArrayList<Account> getAllAccounts();
	// Add account
	public Account addAccount(AccountType at, int user_id, double balance);
	// Update account
	public Account updateAccountBalance(double bal, int id);
	
}
