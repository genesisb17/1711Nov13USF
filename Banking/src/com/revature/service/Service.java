package com.revature.service;

import java.util.ArrayList;
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
		
		ArrayList<String> result = new ArrayList<>();
		result = dao.logOn(u.getUsername(), u.getPassword());
		if(!(dao.getUser().contains(u.getUsername()))) {
			System.out.println("Username does not exist! Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}

		if(result == null) {
			System.out.println("Username/Password mismatch. Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}
		
		System.out.println();
		System.out.println("Your Account Balance:");
		//System.out.println(result);
		double bal = Double.parseDouble(result.get(4));

		System.out.println(bal);
		return u;
	}

}