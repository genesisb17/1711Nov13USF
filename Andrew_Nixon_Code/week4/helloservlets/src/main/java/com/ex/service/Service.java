package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {
	
	static ArrayList<User> users = new ArrayList<User>();
	static {
		users.add(new User("test1", "121"));
		users.add(new User("test2", "122"));
		users.add(new User("test3", "123"));
		users.add(new User("test4", "124"));
		users.add(new User("test5", "125"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User validateUser(String username) {
		for(User u: users) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}

}
