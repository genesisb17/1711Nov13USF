package com.rev.run;

//import java.util.InputMismatchException;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {

	static Service service = new Service();
	
	public static void main(String[] args) {
		run();
		
	}
	
	static void run() {
		int option1, option2;
		System.out.println("Welcome to Yosuf's bank\nPlease choose an option "
				+ "from the following:\n(1) Log in\n(2) Create Account");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		switch(op) {
		case 1: 
			User u1 = new User();
			u1 = login();
			if(u1 == null) run();
			System.out.println("Welcome to your home page. Please choose an option"
					+ " from the following: \n(1) View Balance\n(2) Make Transaction"
					+ "\n(3) Logout");
			Scanner scan1 = new Scanner(System.in);
			option1 = scan1.nextInt();
			
			switch(option1) {
				case 1:
					viewBalance(u1);
					break;
				case 2:
					depositOrWithdraw(u1);
					break;
				case 3:
					run();
				}
			
			break;
		case 2: 
			User u2 = new User();
			u2 = createAccount();
			System.out.println("Welcome to your home page. Please choose an option"
					+ " from the following: \n(1) View Balance\n(2) Make Transaction"
					+ "\n(3) Logout");
			Scanner scan2 = new Scanner(System.in);
			option2 = scan2.nextInt();
			switch(option2) {
			case 1:
				viewBalance(u2);
				break;
			case 2:
				depositOrWithdraw(u2);
				break;
			case 3:
				run();
			}
			break;
		default: run();
		}	
	}

	static User login() {
		boolean b = true;
		boolean c = false;
		System.out.println("Please enter your username:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		
		User logged = new User();
		logged = service.getUserByUsernameToLogin(username);
		if(logged != null) {
			System.out.println("Please enter your password:");
			Scanner scan1 = new Scanner(System.in);
			String password = scan1.nextLine();
			
			while(b) {
			if(service.getUserByPasswordToLogin(password, username) != null) {
				System.out.println("Login Successful!");
				b = false;
				c = true;
			}
			else {
					System.out.println("Incorrect Password. Please choose an option from the "
						+ "following:\n" + "(1) Enter correct password\n(2) Return to home");
					Scanner scan2 = new Scanner(System.in);
					int decision = scan.nextInt();
					switch(decision) {
					case 1:
						scan1 = new Scanner(System.in);
						password = scan1.nextLine();
						break;
					case 2: 
						run();
					default: 
						b = false;
						break;
					}
				}
			}
		}	
		return logged;
	}

	static User createAccount() {
		User u = new User();
		Double deposit = 0.0;
		boolean f = true;
		
		// Read all user information from the console
		System.out.println("Please enter your first name:");
		Scanner scan = new Scanner(System.in);
		String Fname = scan.nextLine();
		System.out.println("Please enter your last name:");
		Scanner scan1 = new Scanner(System.in);
		String Lname = scan1.nextLine();
		System.out.println("Please create a username:");
		Scanner scan2 = new Scanner(System.in);
		String username = scan2.nextLine();
		System.out.println("Please create a password:");
		Scanner scan3 = new Scanner(System.in);
		String password = scan3.nextLine();
		System.out.println("Enter your deposit amount:");
		Scanner scan4 = new Scanner(System.in);
		deposit = scan4.nextDouble();
		
		/*
		//ASK IF USER WANTS TO MAKE A DEPOSIT, AND ONLY ACCEPT NUMERICAL INPUTS
		//FOR THE APPLICATION TO BE MORE FUNCTIONAL
		while(f) {
			System.out.println("Would you like to make a deposit now?\n(1) Yes\n(2) No");
			Scanner scan5 = new Scanner(System.in);
			String op = scan5.nextLine();
			switch(op) {
			case "1": 
				System.out.println("Please enter the amount you wish to deposit: ");
				try {
					Scanner scan6 = new Scanner(System.in);
					deposit = scan6.nextDouble();
					f = false;
				} catch(java.util.InputMismatchException e) {
					System.out.println("Please enter a valid amount!");
					//e.printStackTrace();
					f = true;
				}
			case "2": 
				f = false;
				break;
			default: 
				System.out.println("Please make a valid selection!");	
			}
		}
		*/
		// Set the inserted data to the objects
		u.setFirstname(Fname);
		u.setLastname(Lname);
		u.setUsername(username);
		u.setPassword(password);
		u.setBalance(deposit);
		
		// If username is taken, ask the user to register again
		if(service.addUser(u) == null) {
			System.out.println("Username is not available! :'(\nPlease register again"
					+ " using a different username");
			createAccount();
		}
		return u;
	}

	static void viewBalance(User u) {
		System.out.println("Your current balance is: $" + u.getBalance());
		depositOrWithdraw(u);
	}
	
	static void depositOrWithdraw(User u) {
		System.out.println("Please choose one option from the following:\n(1) Withdraw\n"
				+ "(2) Deposit\n(3) View Balance\n(4) Logout");
		int z;
		double d;
		Scanner scan = new Scanner(System.in);
		z = scan.nextInt();
		switch(z) {
		case 1:
			System.out.println("Please enter the amount you want to withdraw");
			Scanner scan1 = new Scanner(System.in);
			d = scan1.nextDouble();
			User i = new User();
			i = service.withdraw(u, d);
			while(i == null) {
				System.out.println("You don't have sufficient funds!\nPlease choose an option"
						+ " from the following options:\n(1) Withdraw\n"
						+ "(2) Back to main menu\n(3) Logout");
				Scanner scan3 = new Scanner(System.in);
				int j = scan3.nextInt();
				switch(j) {
				case 1: 
					System.out.println("Enter the amount you would like to withdraw");
					Scanner scan5 = new Scanner(System.in);
					double g = scan5.nextDouble();
					i = service.withdraw(u, g);
					break;
				case 2: 
					depositOrWithdraw(u);
				case 3:
					run();
				}
			}
			System.out.println("Transaction Complete");
			depositOrWithdraw(u);
		case 2:
			boolean bool = true;
			System.out.println("Enter the amount you want to deposit");
			Scanner scan2 = new Scanner(System.in);
			d = scan2.nextDouble();
			User o = new User();
			i = service.deposit(u, d);
			System.out.println("Transaction Complete");
			depositOrWithdraw(u);
			break;
		case 3:
			System.out.println("Your current balance is: $" + u.getBalance());
			depositOrWithdraw(u);
		case 4:
			run();
		default:
			run();
		}
	}
}