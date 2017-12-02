package com.ex.test;

import java.util.Scanner;

import com.ex.pojos.Accounts;
import com.ex.pojos.Users;
import com.ex.service.Service;

public class Main {
	
	static Service service = new Service();
	
	public static void main(String[] args) {
		run();
	}
	
	static void run() {
		// Choose to login is create account
		System.out.println("Welcome to Yosuf's bank\nPlease choose an option "
				+ "from the following:\n(1) Create Account\n(2) Login");
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		switch(op) {
		//----------------------- CREATE ACCOUNT THEN LOGIN------------------------------
		case 1: 
			Users u = new Users();
			u = createAccount();
			System.out.println("Account successfully created. Please Login ");
			u = login();
			// If username is invalid
			if(u == null) {
				System.out.println("Username Invalid!");
				run();
			}
			System.out.println("Welcome to your home page. Please choose an option"
					+ " from the following: \n(1) Make Transaction\n(2) View Balance"
					+ "\n(3) Logout");
			Scanner scan = new Scanner(System.in);
			int option = scan.nextInt();	
			switch(option) {
				case 1:
					transaction(u);
					break;
				case 2:
					viewBalance(u);
					break;
				case 3:
					run();
				default:
					System.out.println("Unknown Request!");
					run();
				}
			
			break;
		//---------------------------------- LOGIN ---------------------------------------
		case 2:
			Users u1 = new Users();
			u1 = login();
			if(u1 == null) {
				System.out.println("Username Invalid!");
				run();
			}
			System.out.println("Welcome to your home page. Please choose an option"
					+ " from the following: \n(1) Make Transaction\n(2) View Balance"
					+ "\n(3) Logout");
			Scanner scan1 = new Scanner(System.in);
			int option1 = scan1.nextInt();	
			switch(option1) {
				case 1:
					transaction(u1);
					break;
				case 2:
					viewBalance(u1);
					break;
				case 3:
					run();
				default:
					System.out.println("Unknown Request!");
					run();
				}
			
		// -------------------------- RUN APPLICATION AGAIN ---------------------------------
		default: 
			System.out.println("Request Unknown.... User logged out");
			run();
		}		
	}
	
	private static Users createAccount() {
		// Create object for user
		Users u = new Users();
		// Read all user information from the console
		System.out.println("Please enter your first name:");
		Scanner scan = new Scanner(System.in);
		String Fname = scan.nextLine();
		System.out.println("Please enter your last name:");
		Scanner scan1 = new Scanner(System.in);
		String Lname = scan1.nextLine();
		System.out.println("Please create a username:");
		Scanner scan2 = new Scanner(System.in);
		String username = scan2.nextLine();
		System.out.println("Please create a password:");
		Scanner scan3 = new Scanner(System.in);
		String password = scan3.nextLine();
		// Set the inserted data in the object
		u.setFirstname(Fname);
		u.setLastname(Lname);
		u.setUsername(username);
		u.setPassword(password);
		// If username is taken, ask the user to register again
		if(service.createAccount(u) == null) {
			System.out.println("Username is already taken! :'(\nPlease register again"
					+ " using a different username");
			createAccount();
		}
		return u;
	}
	
	private static Users login() {
		boolean b = true;
		System.out.println("Please enter your username:");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		Users u = new Users();
		u = service.VerifyUsernameToLogin(username);
		//System.out.println("HERE");
		if(u != null) {
			System.out.println("Please enter your password:");
			Scanner scan1 = new Scanner(System.in);
			String password = scan1.nextLine();
			
			while(b) {
			if(service.VerifyPasswordToLogin(password, username) != null) {
				System.out.println("Login Successful!");
				b = false;
			}
			else {
					System.out.println("Incorrect Password. Please choose an option from the "
						+ "following:\n" + "(1) Enter correct password\n(2) Return to home");
					Scanner scan2 = new Scanner(System.in);
					int decision = scan.nextInt();
					switch(decision) {
					case 1:
						System.out.println("Please enter the password:");
						scan1 = new Scanner(System.in);
						password = scan1.nextLine();
						break;
					case 2: 
						run();
					default: 
						b = false;
						break;
					}
				}
			}
		}
		return u;
	}

	private static Users transaction(Users u) {
		
		Accounts a = new Accounts();
		Users x = new Users();
		
		System.out.println("Please choose one option from the following:\n(1) Withdraw\n"
				+ "(2) Deposit\n(3) View Balance\n(4) Logout");
		int z;
		Scanner scan = new Scanner(System.in);
		z = scan.nextInt();
		
		switch(z) {
		case 1:
			System.out.println("Please enter the amount you want to withdraw");
			Scanner scan1 = new Scanner(System.in);
			double d = scan1.nextDouble();
			a.setU_id(u.getU_id());
			x = service.withdraw(u, a, d);
			if(x != null) {
				System.out.println("Transaction Complete");	
				transaction(u);
			}
			else {
				System.out.println("Error occured. User logged out!");
				run();
			}
			break;
		case 2:
			System.out.println("Enter the amount you want to deposit");
			Scanner scan2 = new Scanner(System.in);
			double d1 = scan2.nextDouble();
			a.setU_id(u.getU_id());
			System.out.println("The username is: " + u.getUsername());
			x = service.deposit(u, a, d1);
			if(x != null) {
				System.out.println("Transaction Complete");	
				transaction(u);
			}
			else {
				System.out.println("Error occured. User logged out!");
				run();
			}
			break;
		case 3:
			viewBalance(u);
		case 4: 
			run();
		default:
			run();
		}		
		return null;
	}
	
	private static void viewBalance(Users u) {
		Accounts a = new Accounts();
		a = service.viewBalance(u);
		if(a == null) {
			System.out.println("User has no balance yet!");
			transaction(u);
		}
		System.out.println("Your current balance is: $" + a.getBalance());
		transaction(u);	
	}
	
}