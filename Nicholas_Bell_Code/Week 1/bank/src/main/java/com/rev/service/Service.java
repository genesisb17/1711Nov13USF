package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User getUser(String username) {
		return dao.getUser(username);
	}
	
	public User addUser(User u) {
		
		dao.addUser(u);
		return u;
		
	}
	
	public boolean userNameExists(String name) {
		
		User temp = dao.getUser(name);
		
		if(temp == null) return false;
		else			 return true;
	}

	public boolean checkPassword(User u, String password) {

		if (u.getPassword().equals(password)) return true;
		else 								  return false;
		
	}
	
	
	public boolean canWithdraw(User u, double d) {
		if(u.getBalance() < d) return false;
		else return true;
	}
	
	public User withdrawFunds(User u, double d) {
		
			return dao.changeBalance(u, false, d);
			
	}
	
	public User depositFunds(User u, double d) {
			return dao.changeBalance(u, true, d);
	}
		
	

}
