package com.rev.project1.service;

import java.util.List;

import com.rev.project1.dao.ERSDao;
import com.rev.project1.dao.ERSDaoImpl;
import com.rev.project1.domain.ReimbStatus;
import com.rev.project1.domain.Reimbursement;
import com.rev.project1.domain.User;

public class Service {
	
	/** Create an ERSDao object */
	static ERSDao dao = new ERSDaoImpl();
	
	/**
	 * Check if the username is unique
	 * @param u user
	 * @return true if the username is unique, false otherwise
	 */
	public boolean uniqueUsername(String username) {
		return dao.uniqueUsername(username);
	}
	
	/**
	 * Check if the email is unique
	 * @param email user's email
	 * @return true if the email is unique, false otherwise
	 */
	public boolean uniqueEmail(String email) {
		return dao.uniqueEmail(email);
	}
	
	/**
	 * Add a new user to the system
	 * @param u new user
	 * @return new user
	 */
	public User addUser(User u) {
		if(dao.uniqueUsername(u.getUsername()) && dao.uniqueEmail(u.getEmail())) {
			u = dao.addUser(u.getUsername(), u.getPassword(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getRoleId());
			return u;
		}
		return null;
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User validateUser(String username) {
		return dao.getUserByName(username);
	}
	
	public User updateUser(User u) {
		return dao.updateUser(u);
	}
	
	public int getReimbAuthor(int reimbId) {
		return dao.getReimbAuthorByReimbId(reimbId);
	}
//	/**
//	 * Validate if both username and password match in the system
//	 * @param username user's username
//	 * @param password user's password
//	 * @return true if username and password match, false otherwise
//	 */
//	public boolean validateLogin(String username, String password) {
//		User u = dao.getUserByName(username);
//		if(u != null) {
//			if(password.equals(u.getPassword())) return true;
//		}
//		return false;
//	}
	
	/**
	 * Submit a reimbursement request.
	 * @param r reimbursement
	 * @return new reimbursement
	 */
	public Reimbursement subRequest(Reimbursement r) {
		r = dao.subReimb(r);
		return r;
	}
	
	/**
	 * Return a list of past reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of past reimbursement
	 */
	public List<Reimbursement> viewPastTickets(int reimbAuthor) {
		return dao.getAllPastReimbs(reimbAuthor);
	}
	
	/**
	 * Return a list of pending reimbursement for a specified user
	 * @param reimbAuthor reimbursement author
	 * @return a list of pending reimbursement
	 */
	public List<Reimbursement> viewPendingRequests(int reimbAuthor){
		return dao.getAllPendingReimbs(reimbAuthor);
	}
	
	/**
	 * Return a list of all reimbursement tickets for a given author
	 * @return a list of all reimbursement tickets for a given author
	 */
	public List<Reimbursement> viewAllTickets(int reimbAuthor){
		return dao.getAllReimbs(reimbAuthor);
	}
	
	/**
	 * Return a list of all pending reimbursement requests
	 * @return a list of all pending reimbursement requests
	 */
	public List<Reimbursement> viewAllPendingRequests(){
		return dao.getAllPendingReimbs();
	}

	/**
	 * Return a list of all past reimbursement requests
	 * @return a list of all past reimbursement requests
	 */
	public List<Reimbursement> viewAllPastRequests(){
		return dao.getAllPastReimbs();
	}
	
	public List<Reimbursement> viewAllRequests(){
		return dao.getAllReimbs();
	}
	
	/**
	 * Authorized requests for expense reimbursement
	 * @param r pending reimbursement
	 * @param resolver manager user id
	 * @param status reimbursement status
	 */
	public void authorizedRequest(int reimbId, int resolver, int status) {
		dao.updateReimb(reimbId, resolver, status);
	}
}
