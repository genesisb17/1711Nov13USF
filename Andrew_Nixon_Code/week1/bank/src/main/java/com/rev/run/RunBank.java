package com.rev.run;

import java.util.Scanner;

import org.omg.CORBA.Current;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {

	private static Service service = new Service();
	private static User currentUser = null;
	
	public static void main(String[] args) {
		
		run();
		//System.out.println(testGetUser("uname").toFile());
		
	}

	static void run() {

		System.out.println("Welcome to the Bank\nWould you like to login(1) or create an account(2)?");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1":
			login();
			break;
		case "2":
			createAccount();
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			run();
		}
	}
	
	static void runLoggedIn() {
		
		
		System.out.println("You have successfully logged into your account.\nWhat would you like to do?\n"
				+ "Check balance(1), Deposit money(2), Withdraw money(3), Log out(4)");
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1":
			service.getBalance(currentUser);
			runLoggedIn();
			break;
		case "2":
			depositMoney();
			service.getBalance(currentUser);
			runLoggedIn();
			break;
		case "3":
			withdrawMoney();
			service.getBalance(currentUser);
			runLoggedIn();
			break;
		case "4":
			System.out.println("Goodbye.");
			System.exit(0);
		default:
			System.out.println("Invalid input. Please try again.");
			runLoggedIn();
		}
		
	}

	static User login() {
		System.out.println("Please type in your user name.");
		Scanner scan = new Scanner(System.in);
		String userName = scan.next();
		User u = service.getUser(userName);
		if (u == null) {
			System.out.println("Invalid username");
			login();
		}
		System.out.println("Please type in your password.");
		String password = scan.next();
		if (!u.getPassword().contentEquals(password)) {
			System.out.println("Sorry. Your password does not match your username. Please try again.");
			login();
		}
		else {
			currentUser = u;
			runLoggedIn();
		}
		return null;
	}
	
	static double depositMoney() {
		System.out.println("How much money will you be depositing?");
		Scanner scan = new Scanner(System.in);
		String amount = scan.next();
		service.depositMoney(currentUser, Double.parseDouble(amount));
		return 0;
	}
	
	static double withdrawMoney() {
		System.out.println("How much money will you be withdrawing?");
		Scanner scan = new Scanner(System.in);
		String amount = scan.next();
		service.depositMoney(currentUser, -Double.parseDouble(amount));
		return 0;
	}
	
	static double getBalance() {
		System.out.println("Your balance is $" + service.getBalance(currentUser));
		return 0;
	}

	static User createAccount() {
		User u = new User();
		System.out.println("Welcome. Please enter your first name");
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		System.out.println("Please enter your last name.");
		String lastName = scan.next();
		System.out.println("Please enter your username.");
		String userName = scan.next();
		System.out.println("Please enter your password.");
		String password = scan.next();
		System.out.println("Please enter your initial deposit.");
		String balance = scan.next();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setUserName(userName);
		u.setPassword(password);
		u.setBalance(Double.parseDouble(balance));
		service.addUser(u);
		currentUser = u;
		runLoggedIn();
		return null;
	}
	
	
	
	static User testGetUser(String str) {
		return service.getUser(str);
	}

}
