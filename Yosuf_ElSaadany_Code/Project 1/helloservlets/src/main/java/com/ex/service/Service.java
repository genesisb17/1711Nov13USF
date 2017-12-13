package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {
	
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("test1", "123"));
		users.add(new User("test2", "123"));
		users.add(new User("test3", "123"));
		users.add(new User("test4", "123"));
		users.add(new User("test5", "123"));
	}

	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User validateUser(String username) {
		for(User u : users) {
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
	}
}

