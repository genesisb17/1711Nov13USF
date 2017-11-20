package com.rev.run;

import java.util.HashMap;
import java.util.Scanner;

import com.rev.exceptions.UserNameInUseException;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	
	static Service service = new Service();

	
	public static void main(String[] args) {

		run();

	}

	static void run() {
		
		System.out.println("+--------------------------------------------------+");
		System.out.print("Welcome to MuhBank!\n\nMain Menu\n\n(1) - Existing user login\n(2) - Create a new account\n\n"
				+ "Selection: ");

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		switch(input) {
			
			// Existing user login option
			case "1":
				User loggedInUser = login(scan);
				
				// if the username used during login is not in the data file
				if (loggedInUser == null) {
					System.out.println("\nUsername does not exist!\n");
					run();
				}
				
				// for when the admin user logins in (username: admin, password: admin)
				else if (loggedInUser.getId() == 0) {
					showAdminMenu(scan);
				}
				
				// for all other users
				else {
					showUserAccountMenu(scan, loggedInUser);
				}
				
				break;
				
			// Create a new account option
			case "2": 	
				System.out.println("\n+--------------------------------------------------+");
				System.out.println("\nFirst time? Let's get some information first.");
				service.createAccount(scan); 
				run();
				break;
				
			// Invalid selection
			default: 	
				System.out.println("Invalid selection...\n");
				run();
				
		}
		
	}
	
	static User login(Scanner scan) {
		
		System.out.println("\n+--------------------------------------------------+");
		System.out.println("\nPlease enter your login credentials.");
		
		// gets username from the user
		System.out.print("\nUsername: ");
		String username = scan.nextLine();
		
		//gets password from the user
		System.out.print("Password: ");
		String password = scan.nextLine();
		
		// goes through a list of all users and matches the given username to validate credentials
		for(User user : service.getAllUsers()) {
			
			if(user.getUserName().equals(username)) {
				
				// stores user attributes in a HashMap for easy reference
				HashMap<String, Object> userAttributes = new HashMap<String, Object>();
				userAttributes.put("id", user.getId());
				userAttributes.put("first_name", user.getFirstName());
				userAttributes.put("last_name", user.getLastName());
				userAttributes.put("username", user.getUserName());
				userAttributes.put("password", user.getPassword());
				userAttributes.put("balance", user.getBalance());
				
				// given password matches password on file for the given username
				if(userAttributes.get("password").equals(password)) {
					System.out.println("\nLogin successful!\n");
					return user;
				}
				
				// given password does not match password on file for the given username
				else {
					System.out.println("\nInvalid login credentials!\n");
					run();
				}
			}			
		}
		
		return null;
	}
	
	static void showUserAccountMenu(Scanner scan, User user) {
		
		System.out.println("+--------------------------------------------------+");
		System.out.print("\nWelcome, " + user.getFirstName() + "!\n\n(1) - Make a deposit\n(2) - Make a withdrawal\n"
				+ "(3) - View balance\n(4) - Return to main menu\n\nSelection: ");
		
		String input = scan.nextLine();
		
		switch (input) {
		
			// Make a deposit option
			case "1":
				try {
					service.makeDeposit(scan, user);
				}
				
				catch (NumberFormatException nfe) {
					System.out.println("You have entered an incorrect value.\nReturning to user account menu...");
					showUserAccountMenu(scan, user);
				}
				
				showUserAccountMenu(scan, user);
				break;
			
			// Make a withdrawal option
			case "2": 
				try {
					service.makeWithdrawal(scan, user);
				}
				
				catch (NumberFormatException nfe) {
					System.out.println("You have entered an incorrect value.\nReturning to user account menu...");
					showUserAccountMenu(scan, user);
				}
				
				showUserAccountMenu(scan, user);
				break;
			
			// View balance option
			case "3":
				service.viewUserBalance(user);
				showUserAccountMenu(scan, user);
				break;
				
			// Return to main menu option
			case "4":
				run();
				
			// Invalid selection
			default:
				System.out.println("Invalid selection...\n");
				showUserAccountMenu(scan, user);
				
		}
	}
	
	
	/*
	 *  Shows a special menu, visible only to administrator (username: admin, password: admin)
	 */
	static void showAdminMenu(Scanner scan) {
		
		System.out.println("+--------------------------------------------------+");
		System.out.print("\nAdministrator Menu\n\n(1) - Print all users to console\n(2) - Find a user\n(3) - Return to main menu\n\nSelection: ");
		String input = scan.nextLine();
		
		switch(input) {
		
			// Print all users to console option
			case "1":	
				System.out.println();
				service.printAllUsers();
				showAdminMenu(scan);
				break;
			
			// Find user by username option
			case "2":
				System.out.print("\n\nEnter the username of the user you wish to find: ");
				String soughtUser = scan.nextLine();
				User retrievedUser = service.getUser(soughtUser);
				
				if(retrievedUser != null) {
					service.printUserToConsole(retrievedUser);
					adminUserViewMenu(scan, retrievedUser);
				}
				
				else {
					showAdminMenu(scan);
				}
				break;
				
			// Return to main menu option
			case "3":
				run();
				break;
			
			// Invalid selection
			default:
				System.out.println("Invalid selection...\n");
				showAdminMenu(scan);
				
		}
		
	}
	
	static void adminUserViewMenu(Scanner scan, User user) {
		
		System.out.print("\nSelect an action to perform on this user.\n\n(1) - Edit first name\n(2) - Edit last name\n(3) - Edit username"
				+ "\n(4) - Edit password\n(5) - Return to previous menu\n\nSelection: ");
		
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
				System.out.print("Enter new username: ");
				newValue = scan.nextLine();
				
				try { 
					service.checkUserNameAvailablility(newValue);
				}
				
				catch (UserNameInUseException uniue) {
					adminUserViewMenu(scan, user);
				}
				
				System.out.println("Username, " + user.getUserName() + " is available!");
				user.setUserName(newValue);
				service.updateUser(user);
				showAdminMenu(scan);
				break;
				
			case "4":
				System.out.print("Enter new password: ");
				newValue = scan.nextLine();
				user.setPassword(newValue);
				service.updateUser(user);
				showAdminMenu(scan);
				break;
				
			case "5":
				showAdminMenu(scan);
				break;
		}
	}

}
