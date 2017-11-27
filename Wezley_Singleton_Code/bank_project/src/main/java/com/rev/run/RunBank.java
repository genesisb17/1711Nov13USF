package com.rev.run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.rev.pojos.Account;
import com.rev.pojos.AccountRegistrar;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {

	static Service service = new Service();


	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)){
			run(scan);
		}

	}

	static void run(Scanner scan) {

		System.out.println("+--------------------------------------------------+");
		System.out.print("Welcome to MuhBank!\n\nMain Menu\n\n(1) - Existing user login\n(2) - Create a new user account\n\n"
				+ "Selection: ");
		String input = scan.nextLine();

		switch(input) {

		// Existing user login option
		case "1":
			User loggedInUser = loginMenu(scan);

			// if the username used during login is not in the data file
			if (loggedInUser == null) {
				run(scan);
			}

			// for when the admin user logins in (username: admin, password: admin)
			else if (loggedInUser.getId() == 1) {
				showAdminMenu(scan);
			}

			// for all other users
			else {
				showUserMenu(scan, loggedInUser);
			}

			break;

			// Create a new account option
		case "2": 	
			System.out.println("\n+--------------------------------------------------+");
			System.out.println("\nFirst time? Let's get some information first.");
			service.createNewUser(scan); 
			run(scan);
			break;

			// Invalid selection
		default: 	
			System.out.println("Invalid selection...\n");
			run(scan);

		}

	}

	static User loginMenu(Scanner scan) {

		System.out.println("\n+--------------------------------------------------+");
		System.out.println("\nPlease enter your login credentials.");

		// gets username from the user
		System.out.print("\nUsername: ");
		String username = scan.nextLine();

		//gets password from the user
		System.out.print("Password: ");
		String password = scan.nextLine();

		User loggedInUser = service.loginUser(username, password);

		return loggedInUser;

	}

	/**
	 * 
	 * @param scan
	 * @param user
	 */
	static void showUserMenu(Scanner scan, User user) {

		System.out.println("+--------------------------------------------------+");
		System.out.print("\nWelcome, " + user.getFirstName() + "!\n\n"
				+ "(1) - Show accounts\n"
				+ "(2) - Open new account\n"
				+ "(3) - Return to main menu\n\n"
				+ "Selection: ");

		String input = scan.nextLine();

		switch (input) {

		// Show accounts option
		case "1":		
			ArrayList<AccountRegistrar> userAccounts = service.getUserAccounts(user);
			System.out.println("+--------------------------------------------------+");
			System.out.print("User sub-menu -- Select an account\n\n");
			
			if (!userAccounts.isEmpty()) {
				for (AccountRegistrar userAccount : userAccounts) {
					System.out.println("Account id: " + userAccount.getAcctId());
				}
				
				System.out.print("\nSelection (enter the account id): ");
				
				try {
					int userAccountSelection = scan.nextInt();
					Account selectedAccount = service.getAccountById(userAccountSelection);
					
					if (selectedAccount.getAcctId() != 0) {
						showAccountMenu(scan, selectedAccount, user);
					}
					
					else {
						System.out.println("No account selected.\nReturning to user menu...");
						showUserMenu(scan, user);
					}
				}
				
				catch (InputMismatchException ime) {
					System.out.println("Invalid input. Returning to user menu...");
					showUserMenu(scan, user);
				}
			}
			
			else {
				System.out.println("You have no accounts to display.\nReturning to user menu...");
				showUserMenu(scan, user);
			}
			
			break;

		// Open new account option
		case "2": 
			System.out.println("+--------------------------------------------------+");
			System.out.print("\nUser sub-menu -- Open new account\n\n"
					+ "Select an account type\n"
					+ "(1) - Checking\n"
					+ "(2) - Savings\n"
					+ "(3) - Return to user menu\n\n"
					+ "Selection: ");
			String userSelection = scan.nextLine();
			String accountType = "";
			
			switch(userSelection) {
			
			case "1":
				accountType = "checking";
				break;
				
			case "2":
				accountType = "savings";
				break;
				
			case "3":
				showUserMenu(scan, user);
				
			default: 
				System.out.println("Invalid selection.\nReturning to user menu...");
				showUserMenu(scan, user);
				break;
				
			}
			
			Account newAccount = service.createNewAccount(accountType);

			if (newAccount.getAcctId() != 0) {
				System.out.println("New " + newAccount.getAcctType().toLowerCase() + " account successfully created!");
				System.out.println(newAccount);
				service.registerAccountToUser(user, newAccount, "primary");
				showUserMenu(scan, user);
			}

			else {
				System.out.println("Account creation failed!\nReturning to user menu...");
				showUserMenu(scan, user);
			}
			break;

		// Return to user menu option
		case "3":
			run(scan);
			break;
			
		default:
			System.out.println("Invalid selection...\n");
			showUserMenu(scan, user);

		}
	}

	/**
	 * 
	 * @param account
	 */
	static void showAccountMenu(Scanner scan, Account account, User user) {
		
		System.out.println("+--------------------------------------------------+");
		System.out.print("\nAccount " + account.getAcctId() + " menu\n\n"
				+ "(1) - View balance\n"
				+ "(2) - Make a deposit\n"
				+ "(3) - Make a withdrawal\n"
				+ "(4) - Transfer funds to another account\n"
				+ "(5) - Transfer funds from another account\n"
				+ "(6) - Add a secondary user onto account\n"
				+ "(7) - Return to user menu\n\n"
				+ "Selection: ");
		
		String accountMenuSelection = scan.nextLine();
		
		switch(accountMenuSelection) {
		
		// View account balance option
		case "1":
			System.out.println("\nAccount balance: " + account.getBalance());
			showAccountMenu(scan, account, user);
			break;
		
		// Make a deposit option
		case "2":
			System.out.print("Please enter the amount you would like to deposit: ");
			
			try {
				double depositAmount = scan.nextDouble();
				
				if (depositAmount <= 0) {
					System.out.println("Unable to process request: invalid deposit amount\nReturning to account menu...");
					showAccountMenu(scan, account, user);
				}
				
				else {
					double newBalance = account.getBalance() + depositAmount;
					account.setBalance(newBalance);
					service.updateAccountBalance(account);
					showAccountMenu(scan, account, user);
				}
			}
			
			catch (InputMismatchException ime) {
				System.out.println("You have entered an incorrect value.\nReturning to account menu...");
				showAccountMenu(scan, account, user);
			}
			
			break;
		
		// Make a withdrawal option
		case "3":
			System.out.print("Please enter the amount you would like to withdraw: ");
			
			try {
				double withdrawalAmount = scan.nextDouble();
				
				if (withdrawalAmount > account.getBalance()) {
					System.out.println("Unable to process request: Insufficient funds.\nReturning to account menu...");
					showAccountMenu(scan, account, user);
				}
				
				else {
					double newBalance = account.getBalance() - withdrawalAmount;
					account.setBalance(newBalance);
					service.updateAccountBalance(account);
					showAccountMenu(scan, account, user);
				}
			}
			
			catch (InputMismatchException ime) {
				System.out.println("You have entered an incorrect value.\nReturning to account menu...");
				showAccountMenu(scan, account, user);
			}
			
			break;
		
		// Transfer funds to another account option
		case "4":
			ArrayList<AccountRegistrar> userAccounts = service.getUserAccounts(user);
			System.out.println("+--------------------------------------------------+");
			System.out.println("Please select from the following available accounts:\n");
			
			if(!userAccounts.isEmpty()) {
				for(AccountRegistrar userAccount : userAccounts) {
					if(userAccount.getAcctId() != account.getAcctId()) {
						System.out.println("Account id: " + userAccount.getAcctId());
					}
				}
				
				System.out.print("\nSelection (enter the account id): ");
				
				try {
					int userAccountSelection = scan.nextInt();
					Account targetAccount = service.getAccountById(userAccountSelection);
					
					if (targetAccount.getAcctId() != 0) {
						System.out.print("Enter the amount you would like to transfer to account id, " + targetAccount.getAcctId() + ": ");
						double transferAmount = scan.nextDouble();
						
						if (transferAmount > account.getBalance()) {
							System.out.println("Unable to process request: Insufficient funds.\nReturning to account menu...");
							showAccountMenu(scan, account, user);
						}
						
						else {
							double newBalanceForCurrentAccount = account.getBalance() - transferAmount;
							account.setBalance(newBalanceForCurrentAccount);
							
							double newBalanceForTargetAccount = targetAccount.getBalance() + transferAmount;
							targetAccount.setBalance(newBalanceForTargetAccount);
							
							service.updateAccountBalance(account);
							service.updateAccountBalance(targetAccount);
							
							showAccountMenu(scan, account, user);
						}
					}
					
					else {
						System.out.println("No account selected.\nReturning to account menu...");
						showAccountMenu(scan, account, user);
					}
				}
				
				catch (InputMismatchException ime) {
					System.out.println("Invalid input. Returning to account menu...");
					showAccountMenu(scan, account, user);
				}
			}
			
			else {
				System.out.println("You have no other accounts to display.\nReturning to account menu...");
				showAccountMenu(scan, account, user);
			}
			
			break;
			
		// Transfer funds from another account option
		case "5":
			ArrayList<AccountRegistrar> usrAccounts = service.getUserAccounts(user);
			System.out.println("+--------------------------------------------------+");
			System.out.println("Please select from the following available accounts:\n");
			
			if(!usrAccounts.isEmpty()) {
				for(AccountRegistrar userAccount : usrAccounts) {
					if(userAccount.getAcctId() != account.getAcctId()) {
						System.out.println("Account id: " + userAccount.getAcctId());
					}
				}
				
				System.out.print("\nSelection (enter the account id): ");
				
				try {
					int userAccountSelection = scan.nextInt();
					Account targetAccount = service.getAccountById(userAccountSelection);
					
					if (targetAccount.getAcctId() != 0) {
						System.out.print("Enter the amount you would like to transfer from account id, " + targetAccount.getAcctId() + ": ");
						double transferAmount = scan.nextDouble();
						
						if (transferAmount > targetAccount.getBalance()) {
							System.out.println("Unable to process request: Insufficient funds.\nReturning to account menu...");
							showAccountMenu(scan, account, user);
						}
						
						else {
							double newBalanceForCurrentAccount = account.getBalance() + transferAmount;
							account.setBalance(newBalanceForCurrentAccount);
							
							double newBalanceForTargetAccount = targetAccount.getBalance() - transferAmount;
							targetAccount.setBalance(newBalanceForTargetAccount);
							
							service.updateAccountBalance(account);
							service.updateAccountBalance(targetAccount);
							
							showAccountMenu(scan, account, user);
						}
					}
					
					else {
						System.out.println("No account selected.\nReturning to account menu...");
						showAccountMenu(scan, account, user);
					}
				}
				
				catch (InputMismatchException ime) {
					System.out.println("Invalid input. Returning to account menu...");
					showAccountMenu(scan, account, user);
				}
			}
			
			else {
				System.out.println("You have no other accounts to display.\nReturning to account menu...");
				showAccountMenu(scan, account, user);
			}
			
			break;
		
		// Add secondary user to account option
		case "6":
			System.out.print("Enter the username of the user that you would like to add onto this account: ");
			String username = scan.nextLine();
			User userToAdd = service.getUserByUsername(username);
			
			if (userToAdd.getId() != 0) {
				System.out.println("Attempting to register user, " + userToAdd.getUsername() + ", to account id: " + account.getAcctId() + "...");
				AccountRegistrar registeredUserOnAccount = service.registerAccountToUser(userToAdd, account, "secondary");
			
				if (registeredUserOnAccount.getUserId() == userToAdd.getId() && registeredUserOnAccount.getAcctId() == account.getAcctId()) {
					System.out.println("User, " + registeredUserOnAccount.getUserId() + ", successfully registered to account id: " + registeredUserOnAccount.getAcctId());
					showAccountMenu(scan, account, user);
				}
			
				else {
					System.out.println("Unable to register user, " + userToAdd.getId() + ", to account id: " + account.getAcctId());
					showAccountMenu(scan, account, user);
				}
			}
			
			else {
				System.out.println("No records found for username: " + username + "\nReturning to account menu...");
				showAccountMenu(scan, account, user);
			}
			
			
			break;
			
		// Return to user menu option
		case "7":
			showUserMenu(scan, user);
			break;
			
		default:
			System.out.println("Invalid selection.\nReturning to account menu...");
			showAccountMenu(scan, account, user);
			break;
		}
	}
	
	
	/*
	 *  Shows a special menu, visible only to administrator (username: admin, password: admin)
	 *  
	 *  TO-DO: find out why Scanner is misbehaving when returning to showAdminMenu() after searching for user by id
	 *  
	 */
	static void showAdminMenu(Scanner scan) {

		System.out.println("+--------------------------------------------------+");
		System.out.print("\nAdministrator Menu\n\n"
				+ "(1) - Print all users to console\n"
				+ "(2) - Find a user\n"
				+ "(3) - Return to main menu\n\n"
				+ "Selection: ");

		String input = scan.nextLine();

		switch(input) {

		// Print all users to console option
		case "1":	
			System.out.println("\nPrinting all users to console...");
			service.printAllUsers();
			showAdminMenu(scan);
			break;

			// Find user option
		case "2":

			User retrievedUser = null;

			System.out.println("+--------------------------------------------------+");
			System.out.print("Admin sub-menu -- Find a user by id\n\n"
					+ "(1) - Find user by id\n"
					+ "(2) - Find user by username\n"
					+ "(3) - Find user by email address\n"
					+ "(4) - Return to previous menu\n\n"
					+ "Selection: ");

			String findUserSelection = scan.nextLine();

			switch(findUserSelection) {

			case "1":
				System.out.print("Enter the id of the user you wish to lookup: ");
				try {
					int soughtUserId = scan.nextInt();
					retrievedUser = service.getUserById(soughtUserId);
				}

				catch (InputMismatchException ime) {
					System.out.println("Invalid input. Returning to admin menu...");
					showAdminMenu(scan);
				}


				if (retrievedUser.getId() != 0) {
					System.out.println(retrievedUser);
					adminUserViewMenu(scan, retrievedUser);
				}

				else {
					System.out.println("\nNo user found with given id.\nReturning to admin menu...");
				}

				break;

			case "2":
				System.out.print("Enter the username of the user you wish to lookup: ");
				String soughtUsername = scan.nextLine();
				retrievedUser = service.getUserByUsername(soughtUsername);

				if (retrievedUser.getId() != 0) {
					System.out.println(retrievedUser);
					adminUserViewMenu(scan, retrievedUser);
				}

				else {
					System.out.println("\nNo user found with given username.\nReturning to admin menu...");
				}

				break;

			case "3":
				System.out.print("Enter the email address of the user you wish to lookup: ");
				String soughtEmailAddress = scan.nextLine();
				retrievedUser = service.getUserByEmailAddress(soughtEmailAddress);

				if (retrievedUser.getId() != 0) {
					System.out.println(retrievedUser);
					adminUserViewMenu(scan, retrievedUser);
				}

				else {
					System.out.println("\nNo user found with given email address.\nReturning to admin menu...");
				}

				break;

			case "4":
				showAdminMenu(scan);
				break;

			default:
				System.out.println("Invalid selection. Returning to admin menu...");
				showAdminMenu(scan);

			}

			if(retrievedUser != null) {
				retrievedUser.toString();
				showAdminMenu(scan);
			}

			else {
				showAdminMenu(scan);
			}

			break;

			// Return to main menu option
		case "3":
			run(scan);
			break;

			// Invalid selection
		default:
			System.out.println("\nInvalid selection...\n");
			showAdminMenu(scan);

		}

	}

	/**
	 * 
	 * @param scan
	 * @param user
	 */
	static void adminUserViewMenu(Scanner scan, User user) {

		System.out.println("+--------------------------------------------------+");
		System.out.print("Admin sub-menu -- Select an action to perform on this user.\n\n"
				+ "(1) - Edit first name\n"
				+ "(2) - Edit last name\n"
				+ "(3) - Edit email address\n"
				+ "(4) - Edit username\n"
				+ "(5) - Edit password\n"
				+ "(6) - Return to previous menu\n\n"
				+ "Selection: ");

		String input = scan.nextLine();

		String newValue = "";

		switch(input) { 

		case "1":
			System.out.print("Enter first name: ");
			newValue = scan.nextLine();
			user.setFirstName(newValue);
			service.updateUser(user);
			showAdminMenu(scan);
			break;

		case "2":
			System.out.print("Enter last name: ");
			newValue = scan.nextLine();
			user.setLastName(newValue);
			service.updateUser(user);
			showAdminMenu(scan);
			break;

		case "3":
			System.out.print("Enter new email address: ");
			newValue = scan.nextLine();

			System.out.println("Checking to see that the email address, " + newValue + ", is available...");

			if (service.isEmailAvailable(newValue)) {
				user.setEmailAddress(newValue);
				service.updateUser(user);
			}

			else {
				adminUserViewMenu(scan, user);
			}

			showAdminMenu(scan);
			break;

		case "4":
			System.out.print("Enter new username: ");
			newValue = scan.nextLine();

			System.out.println("Checking to see that username, " + newValue + ", is available...");

			if (service.isUsernameAvailable(newValue)) {
				user.setUsername(newValue);
				service.updateUser(user);
			}

			else {
				adminUserViewMenu(scan, user);
			}

			showAdminMenu(scan);
			break;

		case "5":
			System.out.print("Enter new password: ");
			newValue = scan.nextLine();
			user.setPassword(newValue);
			service.updateUser(user);
			showAdminMenu(scan);
			break;

		case "6":
			showAdminMenu(scan);
			break;

		default:
			System.out.println("Invalid selection. Returning to admin's user view menu...");
			adminUserViewMenu(scan, user);
		}
	}

}
