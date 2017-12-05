package com.real.service;

import java.util.ArrayList;

import com.real.pojos.User;

public class Service {

	static ArrayList<User> users = new ArrayList<User>();
	static{
		users.add(new User("test", "123"));
		users.add(new User("yes", "123"));
		users.add(new User("wow", "123"));
		users.add(new User("dean", "pass"));
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User validateUser(String username) {
		for(User u : users) {
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
	}
}
