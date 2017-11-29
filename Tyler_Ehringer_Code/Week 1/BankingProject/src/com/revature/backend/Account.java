package com.revature.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
	
	private int id, passwordHash, dollars, cents;
	private String firstName, lastName, username;
	
	private static List<Integer> ids;
	
	static {
		ids = new ArrayList<>();
	}
	
	
	public Account(String firstName, String lastName, String username, int passwordHash) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.passwordHash = passwordHash;
		Random r = new Random();
		int id;
		do {
			id = r.nextInt();
		}while(!ids.contains(id));
		this.id = id;
	}
	
	
	
	
	
	
	

}
