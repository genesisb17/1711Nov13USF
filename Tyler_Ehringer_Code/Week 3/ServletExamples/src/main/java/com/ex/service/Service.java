package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {
	
	static ArrayList<User> users= new ArrayList<>();
	
	static {
		users.add(new User("bob", "123"));
		users.add(new User("John", "456"));
		users.add(new User("Mike", "789"));
		users.add(new User("matt", "abc"));
		users.add(new User("Jill", "def"));
	}
	
	public ArrayList<User> getUsers(){return users;}
	
	public User validateUser(String username) {
		for(User u : users) if(u.getUsername().equalsIgnoreCase(username)) return u;
		return null;
	}

}
