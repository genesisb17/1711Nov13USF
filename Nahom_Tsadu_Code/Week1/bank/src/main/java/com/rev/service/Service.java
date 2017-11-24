package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new FileDAO();
	
	public User addUser(User u){
//		System.out.println(u.toString());
		ArrayList<User> userList = dao.getAllUsers();
		if(userList.isEmpty() || userList == null){
			//Set default ID for first User
			u.setId(100);
			return dao.addUser(u);
		}else{
			//Auto-Increment User ID
			u.setId((userList.get(userList.size()-1).getId()) + 1);
			return dao.addUser(u);
		}
	}
	
	public User getUser(String uname){
		return dao.getUser(uname);
	}
	
	public User deposit(User u, double amount){
		u.setBalance(Math.round((u.getBalance() + amount)*100)/100.0);
		return dao.deposit(u);
	}
	
	public User withdraw(User u, double amount){
		u.setBalance(Math.round((u.getBalance() - amount)*100)/100.0);
		return dao.withdraw(u);
	}
}
