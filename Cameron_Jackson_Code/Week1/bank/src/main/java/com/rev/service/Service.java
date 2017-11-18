package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User addUser(User u) {
		// validate that username doesn't exist
		if (userExists(u) == true)
			return null;
		// assuming that it does not exist:
		// should probably check number of users to get user ID
		u.setId(dao.numUsers());
		dao.addUser(u);
		return u;
	}
	
	private static boolean userExists(User u) {
		if (dao.getUser(u.getUsername()) != null)
			return true;
		
		return false;
	}
}
