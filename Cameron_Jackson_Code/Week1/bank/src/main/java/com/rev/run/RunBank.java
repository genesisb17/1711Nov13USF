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
				+ " to Log in(1) or Create Account(2)?");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch (input) {
		case "1":
			login(getUserInfo());
			break;
		case "2": 
			createAccount(getNewUserInfo());
			break;
		default: run();
		}
		scan.close();
	}
	
	static User getUserInfo() {
		User u = new User();
		String uName, pass;
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your desired username: ");
		uName = scan.nextLine();
		System.out.println("Enter your desired password: ");
		pass = scan.nextLine();
		
		u.setUsername(uName);
		u.setPassword(pass);
		
		scan.close();
		return u;
	}
	
	static User getNewUserInfo() {
		User u = new User();
		String fName, lName, uName, pass;
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your first name: ");
		fName = scan.nextLine();
		System.out.println("Enter your last name: ");
		lName = scan.nextLine();
		System.out.println("Enter your desired username: ");
		uName = scan.nextLine();
		System.out.println("Enter your desired password: ");
		pass = scan.nextLine();
		
		u.setFirstname(fName);
		u.setLastname(lName);
		u.setUsername(uName);
		u.setPassword(pass);
		
		scan.close();
		return u;
	}
	
	static User login(User u) {
		if ()
		return null;
	}
	
	static void createAccount(User u) { // if flag = true, there was an error in previous attempt
//		if (flag) {
//			System.out.println("");
//		}
		String uName;
	
		Scanner scan = new Scanner(System.in);
		
		u.setBalance(0);
		while (service.addUser(u) == null) {
			System.out.println("Username is taken. Please try another: ");
			uName = scan.nextLine();
			u.setUsername(uName);
		}
		service.addUser(u);
		scan.close();
	}
	
}
