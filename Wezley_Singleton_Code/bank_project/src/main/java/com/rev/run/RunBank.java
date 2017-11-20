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
					System.out.println("\nUsername does not exit!\n");
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
				createAccount(scan); 
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
				+ "(3) - View balance\n\nSelection: ");
		
		String input = scan.nextLine();
		
		switch (input) {
		
			// Make a deposit option
			case "1":
				System.out.println("Deposit functionality not yet implemented...");
				//service.makeDeposit(user);
				break;
			
			// Make a withdrawal option
			case "2": 
				System.out.println("Withdrawal functionality not yet implemented...");
				//service.makeWithdrawal(user);
				break;
			
			// View balance option
			case "3":
				service.viewUserBalance(user);
				showUserAccountMenu(scan, user);
				break;
				
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
		System.out.print("\nAdministrator Menu\n\n(1) - Print all users to console\n(2) - Return to main menu\n\nSelection: ");
		String input = scan.nextLine();
		
		switch(input) {
		
			// Print all users to console option
			case "1":	
				System.out.println();
				service.printAllUsers(); 
				break;
			
			// Return to main menu option
			case "2":
				run();
				break;
			
			// Invalid selection
			default:
				System.out.println("Invalid selection...\n");
				showAdminMenu(scan);
		}
	}
	
	static User createAccount(Scanner scan) {
		
		User u = new User();
		
		u.setId(service.determineIdNumForNewUser());
		
		System.out.print("Enter your first name: ");
		u.setFirstName(scan.nextLine());
		
		System.out.print("Enter your last name: ");
		u.setLastName(scan.nextLine());
		
		System.out.print("Enter your desired username: ");
		u.setUserName(scan.nextLine());
		
		System.out.print("Enter your desired password: ");
		u.setPassword(scan.nextLine());
		
		u.setBalance(0.0);
		
		// attempts to add user to text file, if the username given is already in use throws UserNameInUseException
		try {
			service.addUser(u);
		}
		
		catch (UserNameInUseException uniue) {
			createAccount(scan);
		}
		
		return u;
	}
}
