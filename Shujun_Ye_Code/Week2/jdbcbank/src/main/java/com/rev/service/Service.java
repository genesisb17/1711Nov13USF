package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DAOImpl;
import com.rev.pojos.User;

/**
 * This class 
 * @author Shujun Ye
 */
public class Service {
	
	static DAO dao = new DAOImpl();
	
	// for servlet
	public User validateUser(String username){
		User u = dao.getUser(username);
		return u;
	}
	
	public User addUser(User u) {
		// validate that username does not exist
		if (checkUsername(u.getUsername())) {
			dao.addUser(u);
			return u;
		}
		return null;
	}
	
	/**
	 * checkUsername method checks if the given username exists.
	 * @param username
	 * @return true if username is new, false otherwise
	 */
	public boolean checkUsername(String username) {
		if (dao.getUser(username) == null) {
			return true;
		}
		return false;
	}
	
	public boolean checkLogin(String username, String password) {
		User u = dao.getUser(username);
		if(u != null && u.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public String welcomeUser(String username) {
		return dao.getUser(username).getFirstname();
	}
	
	public String byeUser(String username) {
		return dao.getUser(username).getFirstname();
	}
	
	public double balance(String username) {
		User u = dao.getUser(username);
		return u.getBalance();
	}
	
	public double withdraw(String username, double money) {
		User u = dao.getUser(username);
		if (u.getBalance() < money) {
			return -1;
		} else {
			return dao.withdrawMoney(u, money);
		}
	}
	
	public double deposit(String username, double money) {
		User u = dao.getUser(username);
		return dao.depositMoney(u, money);
	}
	
	/**
	 * @return return latest id
	 */
	public int reportID() {
		ArrayList<User> users = dao.getAllUsers();
		int totalUsers = users.size();
		if (totalUsers == 0) {
			return 0;
		} else {
			return (users.get(users.size() - 1)).getId();
		}
	}
}