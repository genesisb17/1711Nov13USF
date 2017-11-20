package com.rev.run;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

/**
 * 
 * @author Ihsan Taha
 * 
 *         The following program allows users to create a bank account or login
 *         to an existing account and update their balance. The program does not
 *         allow duplicate user names nor invalid user input at any point.
 *
 */
public class RunBank {

	// Create a service to manage user data
	static Service service = new Service();

	public static void main(String[] args) {
		run();
	}

	// Create an account or login to an existing one
	static void run() {
		System.out.println("Welcome to the Bank: Press 1 to login or 2 to create an account");

		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		switch (option) {
		case "1":
			login();
		case "2":
			createAccount();
		default:
			run();
		}
	}

	// Login to account with a valid username and associated password
	static User login() {
		User user = new User();
		System.out.println("Please enter your username: ");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		user.setUserName(option);

		System.out.println("Please enter your password: ");
		scan = new Scanner(System.in);
		option = scan.nextLine();
		user.setPassWord(option);

		if (service.getUser(user) != null)
			accessAccount(user);
		else {
			System.out.println("Sorry, you have entered an invalid user account");
			run();
		}

		return null;
	}

	// Create a new account with a unique username, otherwise return to main menu
	static User createAccount() {
		User user = new User();
		System.out.println("Welcome to Bank of USF!\nPlease enter your first name:");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		user.setFirstName(option);

		System.out.println("Please enter your last name:");
		scan = new Scanner(System.in);
		option = scan.nextLine();
		user.setLastName(option);

		System.out.println("Please enter your username:");
		scan = new Scanner(System.in);
		option = scan.nextLine();
		user.setUserName(option);

		System.out.println("Please enter your password:");
		scan = new Scanner(System.in);
		option = scan.nextLine();
		user.setPassWord(option);

		user.setBalance(0.0d);

		boolean existsAlready = true;
		if (service.addUser(user) != existsAlready)
			accessAccount(user);
		else {
			System.out.println("Sorry, the username you entered already exists.\nPlease enter a different username.");
		}

		return null;
	}

	// Withdraw, deposit, or view balance and update accordingly to file
	static void accessAccount(User user) {
		System.out.println("Hello " + user.getFirstName() + ", what would you like to do?\n"
				+ "Press 1 to withdraw money, 2 to deposit money, 3 to view balance, or 4 to logout");

		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		switch (option) {
		case "1":
			withdrawMoney(user);
		case "2":
			depositMoney(user);
		case "3":
			viewBalance(user);
		case "4":
			run();
		case "5":
			service.deleteUser(user); // For admin only
		default:
			System.out.println("You have entered an invalid answer. Please try again.");
			accessAccount(user);

		}
	}

	// Withdraw money equal or less to the current balance
	static void withdrawMoney(User user) {
		double amount = 0.0d;

		do {
			// for all but the first iteration, check amount
			if (amount > user.getBalance())
				System.out.println("You do not have sufficient funds");

			System.out.println("How much money would you like to withdraw? ");
			Scanner scanWithdraw = new Scanner(System.in);
			try {
				amount = scanWithdraw.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("You have entered an invalid answer. Please Try again.");
				withdrawMoney(user);
			}

		} while (amount > user.getBalance());

		user.setBalance(user.getBalance() - amount);
		service.updateUser(user);
		accessAccount(user);
	}

	// Deposit money into current balance
	static void depositMoney(User user) {
		double amount = 0.0d;

		do {
			// for all but the first iteration, check amount
			if (amount < 0)
				System.out.println("You have entered an invalid amount");

			System.out.println("How much money would you like to deposit? ");
			Scanner scanDeposit = new Scanner(System.in);
			try {
				amount = scanDeposit.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("You have entered an invalid answer. Please Try again.");
				continue;
			}

		} while (amount <= 0);

		user.setBalance(amount + user.getBalance());
		service.updateUser(user);
		accessAccount(user);
	}

	// View current balance
	static void viewBalance(User user) {
		System.out.println("Current Balance: " + user.getBalance());
		accessAccount(user);
	}
}
