package com.rev.service;

import java.util.ArrayList;

public class DemoService {
	
	static ArrayList<String> people = new ArrayList<String>();
	static{
		people.add("Gen");
		people.add("test");
		people.add("another person");
		people.add("testing");
	}
	
	public ArrayList<String> getUsers(){
		return people;
	}
	public String getUserById(int id){
		return people.get(id);
	}
	
	public void addUser(String user){
		people.add(user);
	}
	

}