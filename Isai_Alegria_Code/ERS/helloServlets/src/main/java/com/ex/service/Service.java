package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {

	static ArrayList<User> users = new ArrayList<User>();
	static {
		
		users.add(new User("test","123"));
		users.add(new User("isai","956"));
		users.add(new User("you","blah"));
		users.add(new User("someone","pass"));
		
	}
	
	
	public ArrayList<User> getUsers(){
		
		return users;
	}
	
	
	public User validateUser(String uname) {
		
		for(User u: users) {
			if(u.getUsername().equalsIgnoreCase(uname)) return u;
		}
		
		return null;
			
	}
		
	
}
