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
		
		System.out.println("Welcome to MuhBank\nWould you like to Log in(1) or Create Account(2)?");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		
		switch(op) {
		case "1":	login(); break;
		case "2": 	createAccount();
		default: 	run();
		}
		System.out.println();
		
	}
	
	static User login() {
		return null;
	}
	
	static User createAccount() {
		
		System.out.println("First time? Let's get some information first.\nPlease enter your first name");
		User u = new User();
		u.setFirstName("firstName");
		u.setLastName("lastName");
		u.setUserName("userName");
		u.setPassword("password");
		u.setBalance(100.00);
		service.addUser(u);
		
		return u;
	}

}
