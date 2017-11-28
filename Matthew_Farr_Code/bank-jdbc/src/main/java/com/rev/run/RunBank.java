package com.rev.run;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import com.rev.pojos.Account;
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
	/**
	 * Main loop of the program runs repeatedly, asking the user for input until they enter the
	 * Exit command.
	 */
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
	
	/**
	 * login method
	 * Called when the user selects login from the main menu
	 * Prompts the user to enter a username and password
	 */
	private void login() {
		System.out.println("Welcome to the Login Portal");
		
		String username;
		// Repeat asking the user for a username until they enter a valid username in the database
		while (true) {
			username = cHelper.getTrimmedStringFromPrompt("Please enter your username: ");
			if (service.hasUser(username))
				break;
			System.out.println("Input '" + username + "' did not match any usernames in the database.");
		}
		
		User u = service.getUser(username);
		String password = cHelper.getStringFromPrompt("Please enter your password: ");
		if (u.getPassword().equals(password)) {
			userOptions(u);
		}
		else {
			// Exits the login method and returns to the run method if the passwords don't match
			System.out.println("Password did not match. Exiting Login Portal.");
		}
	}
	
	/**
	 * createUser method
	 * Called from the run method when the user selects the create user option
	 * Allows the user to enter a name, username, and password to add a user to the database
	 */
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
		
		// Adds the user to the database
		User newUser = service.createUser(firstName, lastName, username, password);
		// Enter the user options menu once a user account has been created 
		userOptions(newUser);
	}
	
	/**
	 * userOptions method
	 * Called from the login method or the createUsers method
	 * Allows the user to access their different bank accounts or create a new one
	 */
	private void userOptions(User u) {
		while(true) {
			int options = 1;
			System.out.println("Welcome to your user account " + u.getUsername());
			
			// Create prompts for allowing user to log in to all of their bank accounts
			List<Account> accountsList = service.getUserAccounts(u);
			String accountsPrompt = "Please enter the number for an account you'd like to access, or the exit prompt";
			for (int i=0; i<accountsList.size(); i++) {
				accountsPrompt += "\n(" + options + ") " + accountsList.get(i).getAccountId();
				options++;
			}
			// Create prompt for creating a new bank account
			accountsPrompt += "\n(" + options + ") Create Bank Account";
			options++;
			accountsPrompt += "\n(" + options + ") Exit";
			int selected = cHelper.getIntFromPrompt(accountsPrompt);
			if (selected < 1 || selected > options) {
				System.out.println("Please enter a number in the range of 1 to " + options);
				continue;
			}
			// if an account is selected, move to the bank account options menu
			else if (selected < options-1) {
				accountOptions(accountsList.get(selected-1));
			}
			// if create account is selected, move to the bank account creation menu
			else if (selected == options-1) {
				createBankAccount(u);
			}
			// if exit was selected, return to the main menu
			else {
				return;
			}
		}
	}
	
	/**
	 * createBankAccount
	 * Allows the user to add a new bank account to the database
	 * 
	 * @param u, the User who is adding the account
	 */
	private void createBankAccount(User u) {
		System.out.println("Creating a new bank account for " + u.getUsername());
		while (true) {
			BigDecimal initialDeposit = cHelper.getBigDecimalFromPrompt("Please enter initial deposit: ");
			if ((initialDeposit.compareTo(new BigDecimal(0))) < 0) {
				System.out.println("Initial deposit must be $0 or greater");
			}
			else {
				service.addAccount(u, initialDeposit);
				// when this returns, control returns to the user options menu
				return;
			}
		}
	}
	
	/**
	 * accountOptions
	 * Menu for allowing the user to access different account functions
	 * Allows the user to deposit, withdraw, or view their balance for this account
	 * 
	 * @param a, the account the user is viewing
	 */
	private void accountOptions(Account a) {
		// Repeat this menu until the user selects exit
		System.out.println("Welcome to account number " + a.getAccountId());
		while (true) {
			int op = cHelper.getIntFromPrompt("Would you like to\n(1) Make a Deposit\n(2) Make a Withdrawal\n"
					+ "(3) View your Balance\nOR\n(4) Exit");
			switch(op) {
			case 1:
				deposit(a);
				break;
			case 2:
				withdraw(a);
				break;
			case 3:
				viewBalance(a);
				break;
			case 4:
				// if the user logs out of the account options, return to the user account menu
				System.out.println("Logging out.");
				return;
			default:
				System.out.println("Invalid command. Please input 1, 2, 3, or 4");
				break;
			}
		}
	}
	
	// Prints the balance of Account a, formatted as the system's local currency
	private void viewBalance(Account a) {
		System.out.println("Your current balance is " + NumberFormat.getCurrencyInstance().format(a.getBalance()));
	}
	
	// Collects input from the user and deposits that amount in the account
	private void deposit(Account a) {
		BigDecimal deposit;
		while (true) {
			deposit = cHelper.getBigDecimalFromPrompt("Please enter amount to deposit: ");
			// Make sure deposits are a positive number
			if (deposit.compareTo(new BigDecimal(0)) > 0)
				break;
			System.out.println("Cannot deposit 0 or negative dollars.");
		}
		System.out.println("Depositing " + NumberFormat.getCurrencyInstance().format(deposit) + ".");
		a = service.deposit(a, deposit);
		System.out.println("Your new balance is " + NumberFormat.getCurrencyInstance().format(a.getBalance()));
	}
	
	// Collects input from the user and withdraws that amount from the account
	private void withdraw(Account a) {
		BigDecimal withdraw;
		while (true) {
			withdraw = cHelper.getBigDecimalFromPrompt("Please enter amount to withdraw: ");
			// Make sure the withdrawal isn't more than the current balance
			if (withdraw.compareTo(a.getBalance()) > 0) {
				System.out.println("Cannot withdraw more than your current balance.");
				continue;
			}
			// Make sure the withdrawal is a non-negative number
			if (withdraw.compareTo(new BigDecimal(0)) > 0)
				break;
			System.out.println("Cannot withdraw 0 or negative dollars.");
		}
		System.out.println("Withdrawing " + NumberFormat.getCurrencyInstance().format(withdraw) + ".");
		a = service.withdraw(a, withdraw);
		System.out.println("Your new balance is " + NumberFormat.getCurrencyInstance().format(a.getBalance()));
	}
	
}
