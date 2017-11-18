package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();

	public static void main(String[] args) {
		run();
		
	}
	static void run() {
		System.out.println("Welcome to the bank\nWould you like "
				+ "to Log in(1) or Create Account(2)");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch(input) {
		case "1":
		case "2": createAccount(); break;
		default: run();
		}
	}
	
	static User login() {
		return null;
	}

	static User createAccount() {
		System.out.println("Awesome! Welcome! Please Enter you first name");
//		Scanner scan = new Scanner(System.in);
		User u = new User();
		u.setFirstname("Todd");
		u.setLastname("Merbeth");
		u.setUsername("username");
		u.setPassword("password");
		// deposit $$
		u.setBalance(100.0);
		service.addUser(u);
		return u;
	}
}
