package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();
	static ArrayList<User> userList = new ArrayList<User>();

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
		u.setId(userList.size());  // Set id to the size of the list so that it is incrementing each time we add a user
		dao.addUser(u);  // Ask the dao to write the user to the file
		userList.add(u);  // Add user to the userList
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
	 * Update the balance of the user by the deposit amount
	 */
	public void updateDeposit(User u, double amount) {
		u.setBalance(u.getBalance() + amount); // Update the user's balance to their old balance plus deposit amount
		userList.set(u.getId(), u); // Set the user in the list to this passed user
		dao.updateUserData(userList); // tell the DAO to update the user data
	}
	
	/*
	 * Update the balance of the user by the withdraw amount
	 */
	public boolean updateWithdraw(User u, double amount) {
		if (u.getBalance() >= amount) { // Check that the user has enought money in their account to make the withdraw
			u.setBalance(u.getBalance() - amount); // Update the user's balance to their old balance minus withdraw amount
			userList.set(u.getId(), u); 
			dao.updateUserData(userList);  // tell DAO to update data
			return true;
		}

		return false;
	}

	/*
	 * Update the userList with all the names from the text file. This is called when the program is first run
	 * to make sure the data is accurate.
	 */
	public void updateUsernames() { 
		dao.updateUserList(userList);
	}

}
