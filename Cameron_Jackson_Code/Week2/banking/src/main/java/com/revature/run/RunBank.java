package com.revature.run;

import java.util.Scanner;

import com.revature.pojos.User;
import com.revature.service.BankService;

public class RunBank {

	static BankService service = new BankService();
	
	public static void main(String[] args) {
		run();
	}
	
	static void run() {
		System.out.println("Welcome to The Bank\nWould you like" 
				+ " to create an account(1) or login(2)?");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		User currentUser;
		switch (input) {
		case "1":
			createAccount(scan);
		case "2": 
			System.out.println("Login");
			System.out.println("=====");
			currentUser = login(getUserInfo(scan), scan);
			System.out.println("Login successful.\n");
			mainMenu(currentUser, scan);
			break;
		default: run();
		}
		scan.close();
	}

	static User getUserInfo(Scanner scan) {
		User u = new User();
		String uName, pass;

		System.out.println("Enter your username: ");
		uName = scan.nextLine();
		System.out.println("Enter your password: ");
		pass = scan.nextLine();

		u.setUsername(uName);
		u.setPassword(pass);

		return u;
	}
	
	static void createAccount(Scanner scan) { 
		String firstname, lastname, username, password;

		System.out.println("Please enter your first name: ");
		firstname = scan.nextLine();
		System.out.println("Enter your last name: ");
		lastname = scan.nextLine();
		System.out.println("Enter your desired username: ");
		username = scan.nextLine();
		System.out.println("Enter your desired password: ");
		password = scan.nextLine();
		
		while (service.addUser(firstname, lastname, username, password) != null) {
			System.out.println("Username is taken. Please try another: ");
			username = scan.nextLine();
		}
		
		System.out.println("Account successfully created.\n");
	}
	
}
