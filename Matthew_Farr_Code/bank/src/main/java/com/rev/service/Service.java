package com.rev.service;

import java.math.BigDecimal;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User addUser(User u){
		//validate that username does not exist 
		// assuming that it DNE:
		if (dao.getUser(u.getUsername()) == null) {
			dao.addUser(u);
			return u;
		} else {
			return null;
		}
	}
	
	public User getUser(String username) {
		return dao.getUser(username);
	}
	
	public User updateUser(User u) {
		if (u.getBalance().compareTo(BigDecimal.ZERO) >= 0) {
			u = dao.updateUser(u);
			return u;
		}
		return null;
	}

}
