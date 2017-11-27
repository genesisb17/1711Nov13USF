package com.ex.service;
import java.util.Scanner;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Account;
import com.ex.pojos.User;
public class Service {
	// input and validation done here. 
	static DAO dao= new DAOImpl();
	
	public User getUserbyId1(int id){
		return (dao.getUserById(id));
	}
	
	public boolean addUser(Scanner in) {
		String name,Lastname, username, password;
		System.out.println("Enter your First Name");
		name=in.nextLine();
		System.out.println("Enter your Last Name");
		Lastname=in.nextLine();
		System.out.println("Enter your User Name");
		username=in.nextLine();
		System.out.println("Enter your Password");
		password=in.nextLine();
		if (dao.addUser(name, Lastname, username, password))
		{
			System.out.println("Enter your initial amount");
			double initial=in.nextDouble();
			if (initial<0)
				initial=0;
			if(dao.addAccount(dao.getUserByUname(username), initial))
				return true;
			else
				System.out.println(" not quite sure how you got here");
		}
		return(false);
	}
	
	public User login(Scanner in){
		System.out.println("Enter your username");
		String username = in.nextLine();
		System.out.println("Enter your Password");
		String password = in.nextLine();
		return (dao.doLogin(username, password));
	}
	public User findUser(String username){
		return(dao.getUserByUname(username));
	}
	public Account getAccount(User use){
		return(dao.findAH(use));
	}
	public void updateBal(Account acc, double update)
	{
		if(dao.updateBal(acc, update))
			System.out.println("Account successfully updated \n Current balance: "+ update);
		else
			System.out.println("Account not able to be updated.");
	}
	
	
}
