package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

/**
 * @author Marshall
 * The main class that runs and controls the UI for the application
 */
public class RunBank {
	static Service service = new Service();

	/**
	 * just a function to call the run(); method
	 * @param args
	 */
	public static void main(String[] args) {
		run();
	}

	/**
	 * run method that controls the start
	 * can do login or create an account
	 * if click login, will use login method and if that works will go to mainMenu
	 * if click create account, will go to create account method
	 * then send the user back here to login
	 */
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

	/**
	 * login menu questions to ask the user for the email and password
	 * first asks for the users email and then calls service.getUser
	 * to check if the user exists
	 * if it is not null then it will check the password
	 * @return null if the users email is not found
	 * @return or if found will ask for the password and return that user
	 * and send them to the mainMenu
	 */
	static User login() {
		User u = null;
		System.out.println("Welcome back, please start with entering your email for the account:");
		Scanner scan = new Scanner(System.in);
		u = service.getUser(scan.nextLine());
		if (u!=null) {
			System.out.println("Please enter your password");
			String password = scan.nextLine();
			if (password.equals(u.getPassword()))
				return u;
		}
		return null;
	}

	/**
	 * Used to get values from the user to create a new account
	 * also checks in the addUser of Services if it exists
	 * if it does not exist will add to the bank.txt
	 * @return the user being created
	 */
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
		// deposit $$
		u.setBalance(0);
		service.addUser(u);
		return u;
	}

	/**
	 * mainMenu is used after the user logins
	 * has ViewBalance to check the users balance
	 * withdraw money to take money out of the account
	 * and deposit money to put money inside
	 * @param u is the users account being looked at
	 */
	static void mainMenu(User u) {
		System.out.println("Welcome " + u.getFirstname() + " what would you like to do?");
		while (true) {
			System.out.println("View Balance(1), Deposit money(2), Withdraw Money(3), or Logout(Enter Anything)");
			Scanner scan = new Scanner(System.in);
			String op = scan.nextLine();
			switch (op) {
			case "1":
				System.out.println("Current balance is " + u.getBalance());
				break;
			case "2":
				System.out.println("How much would you like to deposit?");
				try {
					u.setBalance(u.getBalance() + Double.parseDouble(scan.nextLine()));
					System.out.println("New Balance is " + u.getBalance());
					service.update(u);
				}catch(NumberFormatException e){
					System.out.println("Bad Input");
				}
				break;
			case "3":
				System.out.println("How much would you like to withdraw?");
				try {
					u.setBalance(u.getBalance() - Double.parseDouble(scan.nextLine()));
					System.out.println("New Balance is " + u.getBalance());
					service.update(u);
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
