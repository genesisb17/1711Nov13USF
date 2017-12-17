package com.rev.project1.dao;

import java.util.List;

import com.rev.project1.domain.Reimbursement;
import com.rev.project1.domain.User;

/**
 * ERSDAO interface provides CRUD abstract methods for the users.
 * @author Shujun Ye
 */
public interface ERSDao {
	
	/**
	 * Check if the username is unique
	 * @param u user
	 * @return true if the username is unique, false otherwise
	 */
	boolean uniqueUsername(String username);
	
	/**
	 * Check if the email is unique
	 * @param email user's email
	 * @return true if the email is unique, false otherwise
	 */
	boolean uniqueEmail(String email);

	/**
	 * Add the user to the database
	 * @param u user
	 * @return true if the user is successfully added; false otherwise.
	 */
	User addUser(String username, String password, String firstname, String lastname, String email, int roleId);
	
	/**
	 * Return the specified user with the given user id
	 * @param userId user id
	 * @return the user
	 */
	User getUserById(int userId);
	
	/**
	 * Return the specified user with the given username
	 * @param username user's name
	 * @return the user
	 */
	User getUserByName(String username);
	
	/**
	 * 
	 * @param u
	 * @return
	 */
	User updateUser(User u);
	
	/**
	 * Add the reimbursement to the database
	 * @param r reimbursement // need to fix this javadoc
	 * @return reimbursement
	 */
	Reimbursement subReimb(Reimbursement r);

	int getReimbAuthorByReimbId(int reimbId);
	
	/**
	 * Return a list of all users' pending reimbursement
	 * @return a list of all users' pending reimbursement
	 */
	List<Reimbursement> getAllPendingReimbs();
	
	/**
	 * Return a list of pending reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of pending reimbursement
	 */
	List<Reimbursement> getAllPendingReimbs(int reimbAuthor);
	
	/**
	 * Return a list of all users' past reimbursement
	 * @return a list of all users' past reimbursement
	 */
	List<Reimbursement> getAllPastReimbs();
	
	/**
	 * Return a list of past reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of past reimbursement
	 */
	List<Reimbursement> getAllPastReimbs(int reimbAuthor);
	
	/**
	 * Return a list of all reimbursement in the system
	 * @return a list of all reimbursement
	 */
	List<Reimbursement> getAllReimbs();

	/**
	 * Return a list of reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of reimbursement for a specified user
	 */
	List<Reimbursement> getAllReimbs(int reimbAuthor);

	/**
	 * Update the reimbursement info
	 * @param reimbursement id
	 * @param resolver reimbursement resolver id
	 * @param status reimbursement status id
	 */
	void updateReimb(int reimbId, int resolver, int status);
}
