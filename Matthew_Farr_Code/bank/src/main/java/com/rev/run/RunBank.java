package com.rev.run;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.ConsoleHelper;
import com.rev.service.Service;

public class RunBank implements Runnable{
	
	private Service service;
	private ConsoleHelper cHelper;
	
	public static void main(String[] args) {
		RunBank rb = new RunBank();
		rb.service = new Service();
		rb.cHelper = new ConsoleHelper(new Scanner(System.in));
		rb.run();
	}
	
	@Override
	public void run() {
		System.out.println("Welcome to the Bank of Falador!");
		while(true) {
			int op = cHelper.getIntFromPrompt("Would you like to\n(1) Login\n(2) Create Account\nOR"
												+ "\n(3) Exit");
			switch(op) {
			case 1:
				login();
				break;
			case 2:
				createUser();
				break;
			case 3:
				System.out.println("Now exiting application.\nThank you for using Bank of Falador.");
				System.out.println("Enjoy the rest of your day! :)");
				return;
			default:
				System.out.println("Invalid command. Please input 1, 2, or 3");
				break;
			}
		}
	}
	
	private void accountOptions(User u) {
		// Repeat this menu until the user selects exit
		System.out.println("Welcome to your account " + u.getUsername());
		while (true) {
			int op = cHelper.getIntFromPrompt("Would you like to\n(1) Make a Deposit\n(2) Make a Withdrawal\n"
					+ "(3) View your Balance\nOR\n(4) Exit");
			switch(op) {
			case 1:
				deposit(u);
				break;
			case 2:
				withdraw(u);
				break;
			case 3:
				viewBalance(u);
				break;
			case 4:
				System.out.println("Logging out.");
				return;
			default:
				System.out.println("Invalid command. Please input 1, 2, 3, or 4");
				break;
			}
		}
	}
	
	private void login() {
		System.out.println("Welcome to the Login Portal");
		
		String username;
		while (true) {
			username = cHelper.getTrimmedStringFromPrompt("Please enter your username: ");
			if (service.hasUser(username))
				break;
			System.out.println("Input '" + username + "' did not match any usernames in the database.");
		}
		
		User u = service.getUser(username);
		String password = cHelper.getStringFromPrompt("Please enter your password: ");
		if (u.getPassword().equals(password)) {
			accountOptions(u);
		}
		else {
			System.out.println("Password did not match. Exiting Login Portal.");
		}
	}
	
	private void createUser() {
		
		System.out.println("Welcome to the Account Creation Portal");
		
		String firstName, lastName;
		// Get name from user
		firstName = cHelper.getTrimmedStringFromPrompt("Please enter your first name: ");
		lastName = cHelper.getTrimmedStringFromPrompt("Please enter your last name: ");
		
		System.out.println("Awesome! Welcome to the Bank of Falador " + firstName + " " + lastName + "!");
		
		String username;
		// Retry getting the user's username until the username is unique (i.e. not in the userslist already)
		while (true) {
			String str = cHelper.getTrimmedStringFromPrompt("Please enter your new username: ");
			if (!service.hasUser(str)) {
				username = str;
				break;
			}
			System.out.println("Username " + str + " is already taken. Please enter a different username.");
		}
		String password = cHelper.getStringFromPrompt("Please enter your new password: ");
		
		// Retry getting the initial balance until it is valid (a BigDecimal greater than or equal to zero)
		BigDecimal deposit;
		while (true) {
			deposit = cHelper.getBigDecimalFromPrompt("Please enter your initial deposit: ");
			if (deposit.compareTo(new BigDecimal(0)) >= 0)
				break;
			System.out.println("Initial deposit must be greater than or equal to zero");
		}
		
		User newUser = service.createUser(firstName, lastName, username, password, deposit);
		accountOptions(newUser);
	}
	
	private void viewBalance(User u) {
		System.out.println("Your current balance is " + NumberFormat.getCurrencyInstance().format(u.getBalance()));
	}
	
	private User deposit(User u) {
		BigDecimal deposit;
		while (true) {
			deposit = cHelper.getBigDecimalFromPrompt("Please enter amount to deposit: ");
			if (deposit.compareTo(new BigDecimal(0)) > 0)
				break;
			System.out.println("Cannot deposit 0 or negative dollars.");
		}
		System.out.println("Depositing " + NumberFormat.getCurrencyInstance().format(deposit) + ".");
		u = service.updateBalance(u, deposit);
		System.out.println("Your new balance is " + NumberFormat.getCurrencyInstance().format(u.getBalance()));
		return u;
	}
	
	private User withdraw(User u) {
		BigDecimal withdraw;
		while (true) {
			withdraw = cHelper.getBigDecimalFromPrompt("Please enter amount to withdraw: ");
			if (withdraw.compareTo(u.getBalance()) > 0) {
				System.out.println("Cannot withdraw more than your current balance.");
				continue;
			}
			if (withdraw.compareTo(new BigDecimal(0)) > 0)
				break;
			System.out.println("Cannot withdraw 0 or negative dollars.");
		}
		System.out.println("Withdrawing " + NumberFormat.getCurrencyInstance().format(withdraw) + ".");
		u = service.updateBalance(u, withdraw.negate());
		System.out.println("Your new balance is " + NumberFormat.getCurrencyInstance().format(u.getBalance()));
		return u;
	}
	
}
