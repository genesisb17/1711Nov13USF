package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

/**
 * Interaction with the user to perform the functionalities of the Bank.
 * @author Shujun Ye
 */
public class RunBank {
	/** use to scan user input*/
	static Scanner scan = new Scanner(System.in);
	/** create service object to perform different operations for the bank */
	static Service service = new Service();
	
	/**
	 * main method uses to run the Bank
	 * @param args
	 */
	public static void main(String[] args) {	
		run();
	}

	/**
	 * run() method provides login and create account functionalities to a user
	 */
	static void run() {
		System.out.println("Welcome to Bank\nWould you like to Log in(1) or Create Account(2)");
		String op = scan.nextLine();
		switch(op) {
		case "1":
			login();
			scan.nextLine();
		case "2":
			createAccount();
			scan.nextLine();
		default: run();
		}
	}
	
	/**
	 * This method allows a user to login.
	 */
	static void login() {
		System.out.println("Please enter your username: ");
		String username = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		if(service.checkLogin(username, password)) {
			System.out.println("Hello " + service.welcomeUser(username));
			System.out.println("Would you like to view balance(1), deposit(2), withdraw money(3), or logout(4)");
			String op = scan.nextLine();
			double money;
			switch(op) {
			case "1":
				System.out.println("You have $" + service.balance(username) + " in your account");
				promptUser(username);
			case "2":
				System.out.println("Please enter the amount you want to deposit: ");
				money = Double.parseDouble(scan.nextLine());
				System.out.println("Transcation completed!");
				System.out.println("You now have $" + service.deposit(username, money) + " in your account");
				promptUser(username);
			case "3":
				System.out.println("How much money do you want to withdraw?");
				money = Double.parseDouble(scan.nextLine());
				double balance = service.withdraw(username, money);
				if(balance == -1) {
					System.out.println("Insufficient funds!");
				} else {
					System.out.println("Transcation completed!");
					System.out.println("You now have $" + balance + " in your account!");
				}
				promptUser(username);
			case "4":
				System.out.println("Byebye " + service.byeUser(username) + "!");
				System.exit(0);
			}
		} else {
			System.out.println("Invalid Credentials!");
			run();
		}
	}
	
	/**
	 * This method creates a new user.
	 * @return a new user just created
	 */
	static User createAccount() {
		System.out.println("Awesome! Welcome! Please Enter your first name: ");
		String firstname = scan.nextLine();
		System.out.println("Please Enter your last name: ");
		String lastname = scan.nextLine();
		System.out.println("Please Enter your username: ");
		String username = scan.nextLine();
		while (!service.checkUsername(username)) {
			System.out.println("Someone already has that username. Please enter a new one:");
			username = scan.nextLine();
		}
		System.out.println("Please Enter your password: ");
		String password = scan.nextLine();
		System.out.println("Please Enter your balance: ");
		double balance = scan.nextDouble();
		// auto-creating id
		// DAOImpl will overwrite this id
		int id = service.reportID() + 1;
		
		User u = new User(id, firstname, lastname, username, password, balance);
		service.addUser(u);
		return u;
	}
	
	/**
	 * This method provides prompting message.
	 * @param username username for the user
	 */
	static void promptUser(String username) {
		System.out.println("Would you like to view balance(1), deposit(2), withdraw money(3), or logout(4)");
		String op = scan.nextLine();
		double money = 0.0;
		switch(op) {
		case "1":
			System.out.println("You have $" + service.balance(username) + " in your account");
			promptUser(username);
		case "2":
			System.out.println("Please enter the amount you want to deposit: ");
			money = Double.parseDouble(scan.nextLine());
			System.out.println("Transcation completed!");
			System.out.println("You now have $" + service.deposit(username, money) + " in your account!");
			promptUser(username);
		case "3":
			System.out.println("How much money do you want to withdraw?");
			money = Double.parseDouble(scan.nextLine());
			double balance = service.withdraw(username, money);
			if(balance == -1) {
				System.out.println("Insufficient funds!");
			} else {
				System.out.println("Transcation completed!");
				System.out.println("You now have $" + balance + " in your account!");
			}
			promptUser(username);
		case "4":
			System.out.println("Byebye " + service.byeUser(username) +"!");
			System.exit(0);
		}
	}
}