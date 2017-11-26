package com.rev.service;

import java.math.BigDecimal;
import java.util.List;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	private DAO dao;
	
	private int nextId = 1000001;
	
	public Service() {
		super();
		dao = new FileDAO();
	}
	
	public User addUser(User u) {
		//System.out.println("Database already has user " + u.getUsername() + ": " + hasUser(u.getUsername()));
		if (!hasUser(u.getUsername())) {
			List<User> usersList = dao.getUsers();
			usersList.add(u);
			dao.writeUsers(usersList);
		}
		return u;
	}
	
	public User createUser(String firstName, String lastName, String username, String password, BigDecimal balance) {
		if (hasUser(username))
			return null;
		return addUser(new User(generateId(), firstName, lastName, username, password, balance));
	}
	
	public User updateBalance(User u, BigDecimal amount) {
		BigDecimal updatedBalance = u.getBalance().add(amount);
		List<User> usersList = dao.getUsers();
		for (User user : usersList) {
			if (user.getId() == u.getId()) {
				user.setBalance(updatedBalance);
				u = user;
			}
		}
		dao.writeUsers(usersList);
		return u;
	}
	
	private int generateId() {
		while(hasUser(nextId))
			nextId++;
		return nextId;
	}
	
	public User getUser(String username) {
		for (User u : dao.getUsers()) {
			if (u.getUsername().equalsIgnoreCase(username))
				return u;
		}
		return null;
	}
	
	public User getUser(int id) {
		for (User u: dao.getUsers()) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}
	
	// Check for a user already in the users list by the supplied username
	public boolean hasUser(String username) {
		for (User user : dao.getUsers()) {
			if (user.getUsername().equalsIgnoreCase(username))
				return true;
		}
		return false;
	}
	
	// Check for a user id already in the users list
	public boolean hasUser(int id) {
		for (User user : dao.getUsers()) {
			if (user.getId() == id)
				return true;
		}
		return false;
	}
	
}
