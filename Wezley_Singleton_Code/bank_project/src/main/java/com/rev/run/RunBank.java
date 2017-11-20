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
		String op = scan.nextLine();
		
		switch(op) {
			
			case "1":	
				User loggedInUser = login(scan);
				
				if (loggedInUser == null) {
					System.out.println("\nUsername does not exit!\n");
					run();
				}
				
				else if (loggedInUser.getId() == 0) {
					showAdminMenu(scan);
				}
				
				else {
					showUserAccountMenu(scan, loggedInUser);
				}
				
				break;
				
			case "2": 	
				System.out.println("\n+--------------------------------------------------+");
				System.out.println("\nFirst time? Let's get some information first.");
				createAccount(scan); 
				run();
				break;
				
			default: 	
				System.out.println("Invalid selection...\n");
				run();
				
		}
		
	}
	
	static User login(Scanner scan) {
		
		System.out.println("\n+--------------------------------------------------+");
		System.out.println("\nPlease enter your login credentials.");
		
		System.out.print("\nUsername: ");
		String username = scan.nextLine();
		
		System.out.print("Password: ");
		String password = scan.nextLine();
		
		for(User user : service.getAllUsers()) {
			
			if(user.getUserName().equals(username)) {
				
				HashMap<String, Object> userAttributes = new HashMap<String, Object>();
				userAttributes.put("id", user.getId());
				userAttributes.put("first_name", user.getFirstName());
				userAttributes.put("last_name", user.getLastName());
				userAttributes.put("username", user.getUserName());
				userAttributes.put("password", user.getPassword());
				userAttributes.put("balance", user.getBalance());
				
				if(userAttributes.get("password").equals(password)) {
					System.out.println("\nLogin successful!\n");
					return user;
				}
				
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
		
		String userChoice = scan.nextLine();
		
		switch (userChoice) {
		
			case "1":
				System.out.println("Deposit functionality not yet implemented...");
				//service.makeDeposit(user);
				break;
				
			case "2": 
				System.out.println("Withdrawal functionality not yet implemented...");
				//service.makeWithdrawal(user);
				break;
			
			case "3":
				service.viewUserBalance(user);
				showUserAccountMenu(scan, user);
				break;
				
			default:
				System.out.println("Invalid selection...\n");
				showUserAccountMenu(scan, user);
				
		}
	}
	
	static void showAdminMenu(Scanner scan) {
		
		System.out.println("+--------------------------------------------------+");
		System.out.print("\nAdministrator Menu\n\n(1) - Print all users to console\n(2) - Return to main menu\n\nSelection: ");
		String input = scan.nextLine();
		
		switch(input) {
			case "1":	
				System.out.println();
				service.printAllUsers(); 
				break;
				
			case "2":
				run();
				break;
				
			default:
				showAdminMenu(scan);
		}
	}
	
	static User createAccount(Scanner scan) {
		
		User u = new User();
		
		u.setId(service.determineIdNumForNewUser());
		
		System.out.print("Enter your first name: ");
		u.setFirstName(getStringInput(scan));
		
		System.out.print("Enter your last name: ");
		u.setLastName(getStringInput(scan));
		
		System.out.print("Enter your desired username: ");
		u.setUserName(getStringInput(scan));
		
		System.out.print("Enter your desired password: ");
		u.setPassword(getStringInput(scan));
		
		u.setBalance(0.0);
		
		try {
			service.addUser(u);
		}
		
		catch (UserNameInUseException uniue) {
			createAccount(scan);
		}
		
		return u;
	}
	
	static String getStringInput(Scanner scan) {
		return scan.nextLine();
	}
}
