package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();
	
	public User addUser(User u){
		//validate that username does not exist 
		// assuming that it DNE:
		dao.registerUser(u);
		return u;
	}
	
	public static void getUser(String username, String password) {
		
		dao.login(username, password);
		
	}
	
/*	public static void AddMoney(String username, String password, String amount) {
		
		dao.depositMoney(username, password, amount);
		
	}
	
	public static void viewBalance(String username, String password) {
		
		dao.getBalance(username, password);
		
	}
	
	public static void withdrawMoney(String username, String password, String amount) {
		
		dao.withdrawMoney(username, password, amount);
		
	}*/
	
	
}
