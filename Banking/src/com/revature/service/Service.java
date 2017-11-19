package com.revature.service;

import java.util.HashMap;

import com.revature.dao.DAO;
import com.revature.dao.FileDAO;
import com.revature.main.BankDriver;
import com.revature.pojo.User;

public class Service {
	
	static DAO dao = new FileDAO();
	BankDriver reset = new BankDriver();
	public User addUser(User u){
		//validate that username does not exist 
		// assuming that it DNE:
		if(dao.getUser().contains(u.getUsername())) {
			System.out.println("Username is already taken. Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}
		
		dao.addUser(u);
		return u;
	}
	
	
	public User logIn(User u) {
		if(!(dao.getUser().contains(u.getUsername()))) {
			System.out.println("Username does not exist! Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}
		
		return u;
	}

}