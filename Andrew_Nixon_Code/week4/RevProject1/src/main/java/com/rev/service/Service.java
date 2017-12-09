package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.DAOimp;
import com.rev.pojos.ERSUser;

public class Service {
	
	static DAO dao = new DAOimp();
	
	public ERSUser checkUsernameExists(String username) {
		return dao.getERSUserByUsername(username);
	}
	
	public ERSUser getUserByID(int userID) {
		return dao.getUserByID(userID);
	}

}
