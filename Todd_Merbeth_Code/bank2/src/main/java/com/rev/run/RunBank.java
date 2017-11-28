package com.rev.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.dao.DAO;
import com.rev.dao.OracleDAO;
import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();

	public static void main(String[] args) {
		service.updateUsernames(); // Update the list of users for service
		System.out.println("Welcome to the Bank");
		run();
		// ArrayList<User> users = dao.getUsers();
		//
		// for (User user : users) {
		// System.out.println(user);
		// }
		// User test = new User(0, "firstTest2", "lastTest2", "userTest2", "passTest2");
		// System.out.println(dao.addUser(test));
	}

	/*
	 * Run, basically the main menu. Allows users to log in, create and account, or
	 * exit all other inputs are invalid.
	 */
	static void run() {
		System.out.println("Would you like to Log in(1), Create Account(2), or Exit(3)");
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "3": // Exiting the program
			System.out.println("Thank you! Have a great day!");
			break;
		case "1": // Log in
			User u = login(); // Call login function to check if the user exists
			if (u != null) { // If null is not returned the user does exist
				accounts(u); // Allow user to make deposits/withdraws
			}
			run(); // If login fails or user logs out bring them back to this menu
			break;
		case "2":
			createAccount();
			run();
			break;
		default:
			System.out.println("Please enter a valid command"); // If a command that isn't 1, 2, or 3
			run(); // Send user back to main menu
		}
	}

	/*
	 * Checks if the a user exists in the data with the given information
	 */
	static User login() {
		System.out.println("Hello! Please enter username");
		Scanner scan = new Scanner(System.in);
		String un = scan.nextLine();
		User user = service.getUser(un); // Asks getUser in service if the username exists, return the User if it does
		if (user == null) { // If null is returned then no saved User has that name
			System.out.println("Invalid username");
			return null;
		}
		System.out.println("Please enter password");
		String pass = scan.nextLine();
		if (!pass.equals(user.getPassword())) { // Check if the password is correct for the username
			System.out.println("Incorrect password");
			return null;
		}
		System.out.println("Welcome " + user.getFirstname() + "!");
		return user;
	}

	/*
	 * Money method to handle the menu once a user is logged it.
	 */
	static void accounts(User user) {
		System.out.println("Please enter the account id of the account you wish to access, 'new' to "
				+ "create a new account, or 'logout' to logout \nYour current accounts are listed below:"); // before
																											// making
																											// changes
		ArrayList<Account> userAccounts = service.getAccounts(user);
		if (userAccounts.size() == 0) {
			System.out.println("You don't have any accounts at this time, pleae enter 'new' to create one");
		} else {
			for (Account account : userAccounts) {
				System.out.println(account);
			}
		}
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "new":
			Account created = service.createAccount(user);
			if (created.getAcc_id() == 0) {
				System.out.println("Error creating account");
			} else {
				System.out.println("Account created! Your new account id is: " + created.getAcc_id());
			}
			accounts(user);
			break;
		case "logout":
			break;
		default:
			try {
				int acc = Integer.parseInt(op);
				Account chosen = service.getAccount(acc);
				if (chosen.getAcc_id() == 0) {
					System.out.println("Invalid account id, please try again");
				} else {
					money(chosen);
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid command");
			}
			accounts(user);
			break;
		}
	}

	/*
	 * Money method to handle the menu once a user is logged it.
	 */
	static void money(Account account) {
		System.out.println("Your current balance is: $" + account.getBalance()
				+ "\nWould you like to make a Deposit(1) or Withdraw(2) or Switch Accounts(3)?"); // before making
																									// changes
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1": // Deposit
			account = deposit(account); // Call deposit to handle a deposit
			money(account); // Bring them back to this menu after the deposit is handled
			break;
		case "2": // Withdraw
			account = withdraw(account); // Call withdraw to handle a withdraw
			money(account); // Bring back to this menu after the withdraw
			break;
		case "3": // Switch Account
			break;
		default: // Invalid command
			System.out.println("Please enter a valid command");
			money(account);
		}
	}

	/*
	 * Handles deposits
	 */
	static Account deposit(Account account) {
		System.out.println("Enter the amount you would like to deposit: ");
		Scanner scan = new Scanner(System.in);
		try { // Try catch in case something that can't be converted into a double is passed
			String dstr = scan.nextLine();
			double dep = Double.parseDouble(dstr); // double dep = Double.nextDouble
			Account acc = service.updateDeposit(account, dep); // Ask service to update the account balance
			if (acc.getAcc_id() == 0) {
				System.out.println("Error depositing to account");
			} else {
				System.out.println("Balance has been updated");
				account = acc;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid deposit amount");
		}
		return account;
	}

	/*
	 * Handles withdraw
	 */
	static Account withdraw(Account account) {
		System.out.println("Enter the amount you would like to withdraw: ");
		Scanner scan = new Scanner(System.in);
		try { // Catch illegal values
			String wstr = scan.nextLine();
			double wd = Double.parseDouble(wstr);
			// double wd = scan.nextDouble();
			Account acc = service.updateWithdraw(account, wd);
			if (acc == null) {
				System.out.println("You do not have enough funds to withdraw that amount");
			} else if (acc.getAcc_id() != 0) { // Update the user list
				System.out.println("Balance has been updated");
				account = acc;
			} else
				System.out.println("Error withdrawing funds");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid withdraw amount");
		}
		return account;
	}

	/*
	 * Creating Account given input data Check user doesn't exist in service
	 */
	static void createAccount() {
		System.out.println("Awesome! Welcome! Please enter your first name");
		User u = new User();
		Scanner scan = new Scanner(System.in);
		String fn = scan.nextLine();
		u.setFirstname(fn);
		System.out.println("Please enter your last name");
		String ln = scan.nextLine();
		u.setLastname(ln);
		System.out.println("Please enter your desired username");
		String un = scan.nextLine();
		u.setUsername(un);
		System.out.println("Please enter your password");
		String pass = scan.nextLine();
		u.setPassword(pass);
		// deposit $$
		u = service.addUser(u); // ask service to add the account
		if (u == null) { // If null returned the username is already taken by an account
			System.out.println("Error creating account, username taken");
		} else {
			System.out.println("Your account has been created!\n" + "Please log in to make a deposit");
		}
	}

}
