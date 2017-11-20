package com.rev.dao;

import com.rev.pojos.User;

/**
 * @author Marshall
 * DAO interface is used to give the methods
 * for the FileDAO.java
 */
public interface DAO {

	
	/**
	 * addUser is a method used to add a user to the end of the bank.txt file
	 * @param u the user being given to the method
	 * @return return the user u
	 */
	User addUser(User u);
	
	/**
	 * Gets the users info from just the email
	 * @param email the email that the program will be looking for on the text file
	 * @return the user that is trying to login
	 */
	User getUser(String email);
	
	/**
	 * Update function that reads the whole bank.txt in
	 * then loads all that 
	 * @param u the User being updated to the bank.txt
	 */
	void update(User u);
	
}
