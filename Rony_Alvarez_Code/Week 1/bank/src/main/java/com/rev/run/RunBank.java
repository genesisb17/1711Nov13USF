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
		System.out.println("Welcome to Alvarez Bank!\n Would you like to Log in(1) or Create an Account(2)?");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch(op) {
		case "1": login();  break;
		case "2": createAccount(); break;
			default: run();
		}
		
		
		
	}
	
	static User login() {
		
		System.out.println("Welcome back! Please enter your username:");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scan.nextLine();
		
		service.getUser(username, password);
		
		System.out.println("How can we help you today?");
		System.out.println("View Balance(1), Deposit Money(2) or Withdraw Money(3)");
		String op = scan.nextLine();
		
		switch(op) {
			case "1": viewBalance(username, password); break;
			case "2": 
				System.out.println("How much money would you like to deposit?");
				String amount = scan.nextLine();
				addMoney(username, password, amount); break;
			case "3":  
				System.out.println("How much money would you like to withdraw?");
				String wAmount = scan.nextLine();
				withdrawMoney(username, password, wAmount); break;
			default: run(); 
		}
		
		
		return null;
	}
	
	static User createAccount() {
		//System.out.println("Awesome! Welcome!. Please enter your first name: ");
		User u = new User();
		u.setFirstname("Ronyy");
		u.setLastname("Alvarezzzz");
		u.setUsername("usernameee");
		u.setPassword("passssss");
		u.setBalance(1000000000000.0);
		
		
		System.out.println("Account was created successfully!");
		
		service.addUser(u);
		return null;
	}
	
	public static void addMoney(String username, String password, String amount) {
		
		service.AddMoney(username, password, amount);
		
	}
	
	public static void viewBalance(String username, String password) {
		
		service.viewBalance(username, password);
		
	}
	
	public static void withdrawMoney(String username, String password, String amount) {
		
		service.withdrawMoney(username, password, amount);
		
	}
	

}
