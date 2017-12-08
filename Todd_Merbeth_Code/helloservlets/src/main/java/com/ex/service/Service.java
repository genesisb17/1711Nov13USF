package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {

	static ArrayList<User> users = new ArrayList<User>();
	static {
		users.add(new User("test", "123"));
		users.add(new User("Todd", "Merbeth"));
		users.add(new User("admin", "user"));
		users.add(new User("username", "password"));
		users.add(new User("blah", "123"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User validateUser(String username){
		for(User u : users) {
			if(u.getUsername().equalsIgnoreCase(username)) return u;
		}
		return null;
	}
	
}
