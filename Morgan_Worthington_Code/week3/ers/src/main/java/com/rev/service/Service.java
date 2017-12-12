package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DAOImpl;
import com.rev.pojos.User;

public class Service {
	DAO dao=new DAOImpl();
	
	public boolean userExists(String username) {
		boolean exists=false;
		ArrayList<User> users=dao.getUsers();
		for(User u:users) {
			if(u.getUsername().equals(username)) {
				exists=true;
			}
		}
		return exists;
	}
	
	public boolean passwordCorrect(String username, String password) {
		boolean correct=false;
		User u=dao.getUserByUsername(username);
		if(u.getPassword().equals(password)) {
			correct=true;
		}
		return correct;
	}
	
	public void addUser(String [] userInfo) {
		dao.addNewUser(userInfo);
	}
	
	public User getUserByUsername(String username) {
		User u=dao.getUserByUsername(username);
		
		return u;
	}
}
