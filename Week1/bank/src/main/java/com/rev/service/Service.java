package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User addUser(User u){
		//validate that username does not exist 
		// assuming that it DNE:
		dao.addUser(u);
		return u;
	}

}
