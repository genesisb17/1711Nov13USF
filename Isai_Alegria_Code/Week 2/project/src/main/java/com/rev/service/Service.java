package com.rev.service;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.rev.dao.DAO;
import com.rev.dao.ImplDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new ImplDAO();
	
	public User addUser(User u, String username) {
		
		//function to attempt to add desired username
		
		boolean flag = false;
		
		flag = dao.findUser(username);
		
		// checking if username has been taken
		if(flag == true)
		{
			System.out.println("Sorry, but that user name is already taken");
		}
		
		else {
				// findUser will return false if the desired username isn't found.
				// so a call to the addUser function is made.
				dao.addUser(u);
				setAccount(u);
		}
				
		return u;
	}
	
	public boolean getUser(String username, String password) {
		
		return dao.getUser(username,password);
	}

	public User getUser(String username) {
		
		return dao.getUser(username);
	}
	
	public void viewBalance(User u) {
		
		dao.viewBalance(u);
	}
	
	//function for creating account for the first time a username is created
	public void setAccount(User u) {
		
		dao.setAccount(u);
	}
	
	public void deposit(User u,double amount,int acc) {
		
		dao.deposit(u,amount,acc);
	}

	public void withdraw(User u,double amount,int acc) {

		dao.withdraw(u,amount,acc);
		
	}
	
	public void createAnotherAccount(User u) {
		
		dao.createAnotherAccount(u);
	}
	
}
