package com.rev.run;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.Current;

import com.rev.pojos.BankAccount;
import com.rev.pojos.User;
import com.rev.pojos.User2;
import com.rev.service.Service;

public class RunBank {

	private static Service service = new Service();
	private static User currentUser = null;
	
	public static void main(String[] args) {
		
		//System.out.println(testGetUser("uname").toFile());
		runBank();
		
	}

	private static void runBank() {
		System.out.println("Welcome to the Bank\nWould you like to login(1) or create an account(2)?");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		
		switch (op) {
		case "1":
			loginToAccount();
			break;
		case "2":
			User2 user = createAccount();
			loggedIn(service.getAccounts(user));
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			runBank();
		}
		
	}
	
	private static User2 createAccount() {
		System.out.println("initial list of users");
		service.getUsers();
		User2 user = service.addUser();
		service.getUsers();
		return user;
	}

	static User2 loginToAccount() {
		User2 user = new User2();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type in your user name.");
		String userName = scan.next();
		System.out.println("Please type in your password.");
		String password = scan.next();
		user = service.getUserByUnameAndPassword(userName, password);
		System.out.println(user);
		if (user.getUid() == 0) {
			System.out.println("Sorry, the username and login information are incorect.\n"
					+ "Please try again");
			loginToAccount();
		}
		else {
			System.out.println("Welcome loyal customer.");
			ArrayList<BankAccount> accounts = service.getAccounts(user);
			loggedIn(accounts);
		}
		return null;
	}
	
	static User2 loggedIn(ArrayList<BankAccount> accounts) {
		System.out.println("Here are your accounts.");
		for(BankAccount ba: accounts) {
			System.out.println(ba.toString());
		}
		
		System.out.println("What would like to do?\n Make a Deposit(1), make a Withdrawal(2), Create new bank account(3), or logout(4)?");
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		
		int i = 1;
		int accountIndex = 0;
		double amount = 0;

		switch (op) {
		case "1":
			System.out.println("Which Account?");
			i = 1;
			for(BankAccount ba: accounts) {
				System.out.println(ba.toString() + " (" + i + ")");
				i++;
			}
			accountIndex = Integer.parseInt(scan.nextLine()) - 1;
			System.out.println("How much?");
			amount = Double.parseDouble(scan.nextLine());
			double d = service.makeDeposit(accounts.get(accountIndex), amount);
			loggedIn(accounts);
			break;
		case "2":
			System.out.println("Which Account?");
			i = 1;
			for(BankAccount ba: accounts) {
				System.out.println(ba.toString() + " (" + i + ")");
				i++;
			}
			accountIndex = Integer.parseInt(scan.nextLine()) - 1;
			System.out.println("How much?");
			amount = Double.parseDouble(scan.nextLine());
			double w = service.makeWithdrawal(accounts.get(accountIndex), amount);
			loggedIn(accounts);
			break;
		case "3":
			service.createBankAccount(accounts.get(0).getUserID());
			loggedIn(service.getBankAccountsByUser(accounts.get(0).getUserID()));
			break;
		case "4":
			System.out.println("Goodbye.");
			System.exit(0);
		default:
			System.out.println("Invalid input. Please try again.");
			loggedIn(accounts);
		}

		return null;
		
	}
	/*

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
	
	

	/*
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
	*/

}
