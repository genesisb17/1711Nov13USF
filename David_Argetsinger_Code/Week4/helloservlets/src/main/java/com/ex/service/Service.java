package com.ex.service;

import java.util.ArrayList;

import com.ex.pojos.User;

public class Service {
	static ArrayList<User> users = new ArrayList<User>();
	static{
		users.add(new User("test","1213"));
		users.add(new User("teswt","12213"));
		users.add(new User("teste","1233"));
		users.add(new User("testq","12633"));
		users.add(new User("testqq","1623"));
		users.add(new User("teswt","1253"));
		users.add(new User("teest","1243"));
		users.add(new User("tqest","1213"));
		users.add(new User("tewst","1223"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User ValidateUser(String username){
		for (User u : users){
			if (u.getUsername().equalsIgnoreCase(username))
				return u;
		}
		return null;
	}
}
