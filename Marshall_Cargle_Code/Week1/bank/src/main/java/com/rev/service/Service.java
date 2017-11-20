package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

/**
 * @author Marshall
 * Service class that controls the in between of the RunBank
 * and the FileDAO
 */
public class Service {

	static DAO dao = new FileDAO();

	/**
	 * method that calls dao.addUser(u) in the FileDAO.java along with checking if the user is null
	 * @param u the user being added
	 * @return the user back to the method that called this
	 */
	public User addUser(User u) {
		// validate that username does exist
		if (!validateEmail(u)) {
			System.out.println("Sorry that user already exists");
			return null;
		}
		// assuming that it DNE(does not exist):
		dao.addUser(u);
		return u;
	}

	/**
	 * Does a check for if the user exists or not
	 * @param u the user being sent to check if they are equal
	 * @return a boolean if it is null
	 */
	public boolean validateEmail(User u) {
		if (dao.getUser(u.getEmail())==null)
			return true;
		return false;
	}

	/**
	 * Service layer to call the DAO layer of getUser
	 * @param email the email of the user that the method requested
	 * @return
	 */
	public User getUser(String email) {
		return dao.getUser(email);
	}

	/**
	 * calls the update method of the DAO from the service layer
	 * @param u the user being updated on the list
	 */
	public void update(User u) {
		dao.update(u);
	}
}
