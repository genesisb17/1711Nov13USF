package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {
	
	static ArrayList<User> users = new ArrayList<User>();
	static {
		users.add(new User("test","123"));
		users.add(new User("nick","pass"));
		users.add(new User("admin","pass"));
		users.add(new User("jonny","seed"));
		users.add(new User("test2","456"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User validateUser(String username) {
		for(User u : users) {
			if(u.getUsername().equalsIgnoreCase(username))
				return u;
		}
		return null;
	}
}
