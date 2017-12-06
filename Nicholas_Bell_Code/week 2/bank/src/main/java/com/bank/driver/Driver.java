package com.bank.driver;


import java.text.NumberFormat.Field;
import java.util.Scanner;

import com.bank.pojos.Account;



import com.bank.pojos.User;
import com.bank.service.Service;

public class Driver {
	static Service service = new Service();
	public static void main(String[] args) {
		//greet
		run();
		
	}
	
	static void run() {
		String op = "start";
		Scanner scan;
		while(!op.equals("3")) {
		
			System.out.println("Welcome to the Bank!\nWould you like "
					+ "to Login(1), Create A User Account(2) or Quit(3)");
			
			scan = new Scanner(System.in);
			
			op = scan.nextLine();
				switch(op) {
				case "1": login(); break;
				case "2": createAccount(); break;
				case "3": break;
				default:
					//run();
				}
		}		
	}
	
	
	static void login() {
		
		System.out.println("Welcome Back!\n"
				+ "Enter your username:");
		
		
		Scanner scan = new Scanner(System.in);
		String uname = scan.nextLine();
		
		if (!service.userNameExists(uname)) {
			System.out.println("User does not exist");
		}
		else {
			User u = service.getUser(uname);
			System.out.println("Please enter your password:");
			scan = new Scanner(System.in);
			String password = scan.nextLine();
			if(service.checkPassword(u, password)) {
				u.setAccounts(service.getAccounts(u));
				userMenu(u);
			}
			else {
				System.out.println("Incorrect password. Returning to main menu.");
			}
			
		}	
	}
	
	static Account withdrawFunds(Account a) {	
		System.out.println("How much would you like to withdraw?");
		Scanner scan = new Scanner(System.in);
		double d = scan.nextDouble();
		if (service.canWithdraw(a, d)) {
			a = service.withdrawFunds(a, d);
			System.out.println("Done");
			System.out.printf("Your Balance is now %f\n", a.getBalance());
			System.out.println("Back to Customer menu.");
		}
		else
		{
			System.out.println("Insufficient funds.");
						
		}
		return a;
	}
	
	static Account depositFunds(Account a) {
		System.out.println("How much would you like to deposit?");
		Scanner scan = new Scanner(System.in);
		double d = scan.nextDouble();
		a = service.depositFunds(a, d);
		System.out.println("Done");
		System.out.printf("Your Balance is now %f\n", a.getBalance());
		return a;
	}
	
	static void userMenu(User u) {
		System.out.printf("Hello %s %s!\n", u.getFirstname(), u.getLastname());
		String input = "run";
		Scanner scan;
		int numAccounts;
		while(!input.equals("3")){
			numAccounts = u.getAccounts().size();
			System.out.printf("You have %d %s currently open with us.", numAccounts,
					(numAccounts > 1 ? "accounts" : "account"));
			System.out.println("How may we help you?\n"
					+ "Account Actions(1), Create New Account(2), Main Menu(3)");
			scan = new Scanner(System.in);
			int accSelection = -1;
			int fundsSelection = -1;
			input = scan.nextLine();
			
			switch(input) {
			case "1": 
				while(accSelection != 0) {
					System.out.println("Select Account (0 to exit):");
					int index = 0;
					for (Account ac : u.getAccounts()) {
						System.out.println(++index + ") " + ac);
					}
					scan = new Scanner(System.in);
					if(!scan.hasNextInt()) {
						accSelection = -1;
						continue;
					}
					accSelection = scan.nextInt();
					if(accSelection == 0) continue;
					if(accSelection > numAccounts || accSelection < 0) {
						System.out.println("Invalid selection");
						accSelection = -1;
						continue;
					}
					else {
						Account ac = u.getAccounts().get(accSelection-1);
						fundsSelection = -1;
						while(!(fundsSelection==1||fundsSelection==2)) {						
							System.out.println("Would you like to Deposit(1) or Withdraw(2)");
							if(!scan.hasNextInt()) {
								continue;
							}
							else {
								fundsSelection = scan.nextInt();
								if (fundsSelection == 1) {
									ac = depositFunds(ac);//deposit;
									u.getAccounts().remove(accSelection-1);
									u.getAccounts().add(accSelection-1, ac);
								}
								else if(fundsSelection == 2) {
									ac = withdrawFunds(ac);//withdraw							
									u.getAccounts().remove(accSelection-1);
									u.getAccounts().add(accSelection-1, ac);
								}
							}
						}
					
					}
				}
				
				break;
			case "2": 
				Account ack = service.addAccount(u);
				u.addAccount(ack);
				System.out.printf("How much money would you like to open your account with?\n");
				u.getAccounts().set(numAccounts, service.depositFunds(ack, getMoney()));
				u.getAccounts().remove(numAccounts+1);
				break;
			case "3":
				break;
			 default:
			}
		}
	}
	
	static void createAccount() {
		System.out.println("Thank you for choosing us for your banking needs!");
		String firstname = getField(FieldType.FIRST);
		String lastname  = getField(FieldType.LAST);
		
		System.out.printf("Thanks, %s %s!\n"
				+ "Now you will choose your password!\n"
				+ "Please remember it!\n", firstname, lastname);
		
		String password = getField(FieldType.PASSWORD);
		
		System.out.printf("Finally, you will choose your username.\n"
				+ "Each person must have a unique username. If it is taken, you'll have\n"
				+ "to choose another, but don't worry, we've saved your information thus far!\n");
		
		String username  = getField(FieldType.USER);
		
		User u = new User();
		
		User tmp = null;
		u.setFirstname(firstname);
		u.setLastname(lastname);		
		u.setPassword(password);
		
		//ACCOUNT CREATIION LOGIC
		//u.setBalance(funds);
		//
		
		boolean userNameTaken = service.userNameExists(username);
		while(userNameTaken) {
			System.out.println("That username is taken. Please choose another:");			
			username = getField(FieldType.USER);
			userNameTaken = service.userNameExists(username);		
		}
		u.setUsername(username);		
		u = service.addUser(u);
		System.out.println("Congratulations! You've set up your User account!");
		System.out.println("To get you started, we will set up Bank account for you.");
		Account ace = service.addAccount(u);
		u.addAccount(ace);
		System.out.printf("How much money would you like to open your account with?\n");
		service.depositFunds(u.getAccounts().get(0), getMoney());
		
	}
	
	static double getMoney() {
		Scanner mScan = new Scanner(System.in);
		
		//check for valid entry
		while(!mScan.hasNextDouble()) {
			System.out.println("Please enter a valid value for a deposit:");
			
			//clears anything left in scanner
			if(mScan.hasNextLine()) {
				String trash = mScan.nextLine();
			}
			//mScan.close();
			mScan = new Scanner(System.in);
		}
			double money = mScan.nextDouble();
			//mScan.close();
		
			return money;

	}
	
	/*
	 * Function returns a String to the a name(first or last) field
	 * if it is a valid name while clearing opening and
	 * trailing whitespace.
	 */
	static String getField(FieldType type) {
		//a flag to mark invalid entries		
		boolean invalid = false;
		
		//the following String will display the correct
		//nametype to prompt the user when trying to create
		//an account
		String fieldtype = new String();
		switch(type) {
		case FIRST:
			fieldtype = "first name"; break;
		case LAST:
			fieldtype = "last name"; break;
		case USER:
			fieldtype = "username"; break;
		case PASSWORD:
			fieldtype = "password";
		}
		
		//a string that takes an input from user
		String input = new String();
		do {
			System.out.printf("Please enter your %s.\n"
					+ "You may not use the ':' character.\n", fieldtype);
			
			//get name
			//@SuppressWarnings("resource")
			//despite being used in the very next command
			//Eclipse is telling me this scanner is never
			//used. Also, the scanner is closed
			//in the following if/else when the
			//entry is valid. Thus @SuppressWarnings...
		Scanner scan = new Scanner(System.in);					
				input = scan.nextLine();						
				//checks for invalid character
				if (input.indexOf(':') != -1){ 	
					invalid = true;
					System.out.println("Invalid entry.");
				}
				else { 							
					invalid = false;
				}
			
		}while(invalid);		
		return input;
	}
}
