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
	
	public boolean hasUser(String email) {
		return dao.getUsers().stream().anyMatch(u -> u.getEmail().equals(email));
	}
	
	public boolean hasUser(int id) {
		return dao.getUsers().stream().anyMatch(u -> u.getId() == id);
	}
	
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
	
	public User addUser(User u) {
		if(!hasUser(u.getEmail())) {
			List<User> users = dao.getUsers();
			users.add(u);
			dao.writeUsers(users);
		}
		return u;
	}
	
	public User addNewUser(String email, String password, String firstName, String lastName) {
		if(hasUser(email)) return null;
		return addUser(new User(generateNewId(), firstName, lastName, email, password, 0.0f));
	}
	
	private int generateNewId() {
		Random r = new Random();
		int id;
		boolean tryAgain = false;
		do {
			id = r.nextInt();
			for(User u : dao.getUsers()) if(u.getId() == id) tryAgain = true;
		}while(tryAgain);
		return id;
	}
	
	public User getUser(String email) {
		List<User> users = dao.getUsers().stream().filter(u -> u.getEmail().equals(email)).collect(Collectors.toList());
		if(users.size() == 1) return users.get(0);
		return null;
	}
	
	public User getUser(int id) {
		List<User> users = dao.getUsers().stream().filter(u -> u.getId() == id).collect(Collectors.toList());
		if(users.size() == 1) return users.get(0);
		return null;
	}
	

	
}
