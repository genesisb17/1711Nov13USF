package com.rev.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao;
	
	static {
		dao = new FileDAO();
	}
	
	/*
	 * Returns whether the user exists by their email.
	 */
	public boolean hasUser(String email) {
		return dao.getUsers().stream().anyMatch(u -> u.getEmail().equals(email));
	}
	
	/*
	 * Returns whether the user exists by their user id.
	 */
	public boolean hasUser(int id) {
		return dao.getUsers().stream().anyMatch(u -> u.getId() == id);
	}
	
	/*
	 * Changes the user's balance.  Returns the updated user.
	 */
	public User addToBalance(User u, double amount) {
		double newBalance = u.getBalance() + amount;
		for(User user : dao.getUsers()) {
			if(user.getId() == u.getId()) {
				u = user;
				user.setBalance(newBalance);
			}
		}
		return u;
	}
	
	/*
	 * Adds the user to the data system
	 */
	public User addUser(User u) {
		if(!hasUser(u.getEmail())) {
			List<User> users = dao.getUsers();
			users.add(u);
			dao.writeUsers(users);
		}
		return u;
	}
	
	/*
	 * Creates a new user and adds it to the data system
	 */
	public User addNewUser(String email, String password, String firstName, String lastName) {
		if(hasUser(email)) return null;
		return addUser(new User(generateNewId(), firstName, lastName, email, password, 0.0f));
	}
	
	/*
	 * generates a unique user id
	 */
	private int generateNewId() {
		Random r = new Random();
		int id;
		boolean tryAgain = false;
		do { // keep generating new random id's until it is unique
			id = r.nextInt();
			for(User u : dao.getUsers()) if(u.getId() == id) tryAgain = true;
		}while(tryAgain);
		return id;
	}
	
	/*
	 * Retrieves a user by their email
	 */
	public User getUser(String email) {
		List<User> users = dao.getUsers().stream().filter(u -> u.getEmail().equals(email)).collect(Collectors.toList());
		if(users.size() == 1) return users.get(0);
		return null;
	}
	
	/*
	 * Retrieves a user by their id
	 */
	public User getUser(int id) {
		List<User> users = dao.getUsers().stream().filter(u -> u.getId() == id).collect(Collectors.toList());
		if(users.size() == 1) return users.get(0);
		return null;
	}
	

	
}
