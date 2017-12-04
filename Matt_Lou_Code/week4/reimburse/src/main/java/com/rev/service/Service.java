package com.rev.service;
import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.Users;

public class Service {
	static DAO dao = new FileDAO();
	
	public Users validate(String username) {
		Users user = dao.getUser(username);
		if(user.getUsername() != username)
			return null;
		return user;
	}
	
	public Users addUser(Users u) {
		// validate that username does not exist
		// assuming that it does not exist:
		dao.addUser(u);
		return u;
	}
	
	public Users callUpdate(Users u) {
		dao.update(u);
		return u;
	}
	
	
}
