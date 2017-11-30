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
		System.out.println("Welcome to my MarshallBank\nWould you like to Log in(1) or Create Account(2)");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1":
			User u = login();
			if (u==null)
				System.out.println("No user matching that information");
			else
				mainMenu(u);
			run();
		case "2":
			createAccount();
		default:
			run();
		}
	}
	
	static User login() {
		User u;
		String password, email;
		System.out.println("Welcome back, please start with entering your email for the account:");
		Scanner scan = new Scanner(System.in);
		email=scan.nextLine();
		System.out.println("Please enter your password");
		password=scan.nextLine();
		u = service.getUser(email, password);
		if (u==null) {
			return null;
		}
		return u;
	}
	
	static User createAccount() {
		User u = new User();
		Scanner scan = new Scanner(System.in);
		System.out.println("Awesome! Welcome! Please Enter your first name:");
		u.setFirstname(scan.nextLine());
		System.out.println("Next enter your last name:");
		u.setLastname(scan.nextLine());
		System.out.println("Enter the email you would like to use with the account:");
		u.setEmail(scan.nextLine());
		System.out.println("Finally your password for the account:");
		u.setPassword(scan.nextLine());
		service.addUser(u);
		return null;
	}
	
	static void mainMenu(User u) {
		System.out.println("Welcome " + u.getFirstname() + " what would you like to do?");
		while (true) {
			System.out.println("View Balance(1), Deposit money(2), Withdraw Money(3), or Logout(Enter Anything)");
			Scanner scan = new Scanner(System.in);
			String op = scan.nextLine();
			switch (op) {
			case "1":
				System.out.println("Current balance is " + service.getAccount(u.getId()).getBalance());
				break;
			case "2":
				System.out.println("How much would you like to deposit?");
				try {
					System.out.println("New Balance is " + service.setBalance(service.getAccount(u.getId()).getId(),service.getAccount(u.getId()).getBalance() + Double.parseDouble(scan.nextLine())));
				}catch(NumberFormatException e){
					System.out.println("Bad Input");
				}
				break;
			case "3":
				System.out.println("How much would you like to withdraw?");
				try {
					System.out.println("New Balance is " + service.setBalance(service.getAccount(u.getId()).getId(),service.getAccount(u.getId()).getBalance() - Double.parseDouble(scan.nextLine())));
				}catch(NumberFormatException e) {
					System.out.println("Bad Input");
				}
				break;
			default:
				run();
			}
		}
	}
}
