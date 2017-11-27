package com.rev.service;

import com.rev.dao.*;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	
	public User addUser(User u, String username) {
		
		boolean flag;
		//validate that username doesn't exist
		flag = dao.findUser(username);
		
		if(flag == true) {
			System.out.println("Sorry, but that user name is already taken");
		}
		
		else {
				System.out.println("Congratulations, your account has been successfully created!\n");
				dao.addUser(u);
		}
				
		return u;
	}
	
	public double deposit(double amount,String user) {
		
		return dao.deposit(amount,user);
		
	}
	
	public void viewBalance() {
		
		dao.viewBalance();
	}
	
	public void withdraw(double amount,String user) {
		
		dao.withdraw(amount,user);
	}
	
	public boolean getUser(String user,String password) {
		
		return dao.getUser(user,password);
	}
	

}
