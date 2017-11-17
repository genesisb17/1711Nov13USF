package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	
	static Service service = new Service();
	
	public static void main (String[] args) {
		run();
		
	}
	
	static void run() {
		System.out.println("Welcome to The Bank\nWould you like" 
				+ "to Log in(1) or Create Account(2)?");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
		case "2": 
			createAccount();
		default: run();
		}
	}
	
	static User login() {
		return null;
	}
	
	static User createAccount() {
		System.out.println("Great! Please enter your firt name: ");
		User u = new User();
		u.setFirstname("Billy");
		u.setLastname("Boy");
		u.setUsername("username");
		u.setPassword("pass");
		// deposit $$
		u.setBalance(0.1);
		service.addUser(u);
		return null;
	}
}
