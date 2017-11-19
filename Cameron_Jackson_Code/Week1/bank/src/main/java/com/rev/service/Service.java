package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User addUser(User u) {
		// validate that username doesn't exist
		if (userExists(u.getUsername()) == true)
			return null;
		// assuming that it does not exist:
		// should probably check number of users to get user ID
		u.setId(dao.numUsers());
		dao.addUser(u);
		return u;
	}
	
	public User getUser(String username) {
		return dao.getUser(username);
	}
	
	public void updateUser(User u) {
		dao.overwriteUsers(u);
	}
	
	/*
	 * return a user object representing current user 
	 * if successful
	 */
	public User login(String username, String pass) {
		// check username
		if (userExists(username) == false)
			return null;
		
		if (correctPassword(username, pass) == false)
			return null;
		
		return dao.getUser(username);
	}
	
	private static boolean userExists(String username) {
		if (dao.getUser(username) != null)
			return true;
		
		return false;
	}
	
	private static boolean correctPassword(String username, String pass) {
		User check = dao.getUser(username);
		if (check.getPassword().equals(pass))
			return true;
		
		return false;
	}
}
