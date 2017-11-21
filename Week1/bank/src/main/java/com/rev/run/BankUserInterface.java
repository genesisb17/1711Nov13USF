package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class BankUserInterface {
	static Service service = new Service();
	private static Scanner keyboard;
	
	public static void main(String[] args) {
			run();
			
	}
	
	static void run() {
		System.out.println("Welcome to Banking with Felix!\n\n" + "Because of your loyalty to my development, we have restricted \nusage of this high level program only to you!"
				+ "\n\nWould you like " 
				+ "to Log in(1) or Create Account(2)? \n");
		keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		switch(input) {
			case "1":
				User useR = login();
				if(useR.getUserName().equals(null)) {
					run();
				}
				homeScreen(useR);
				break;
			case "2":
				createAccount();
				run();
				break;
			default:
				run();
		}
	}
	
	
		static User depositMoney(User client) {
			System.out.println("For security purposes, if you would like to continue viewing your account, \n you will be required to log in after making your withdrawal.\n");
			System.out.println("How much would you like to deposit? \n");
			double deposit = keyboard.nextDouble();
			User useR = service.getUser(client.getUserName());
	//		System.out.println("Balance in deposit money method is : " + useR.getBalance()); //debugging purpose
	//		System.out.println("Username in the deposit money method: " + useR.getUserName()); //debugging
			useR = service.updateUser(useR, deposit);
			useR = service.getUser(client.getUserName());
			System.out.println("Your balance after your deposit is: " + useR.getBalance() + "\n");
			return useR;
		}
		
		
		static User viewBalance(User client) {
			User useR = service.getUser(client.getUserName());
			System.out.println("Your balance as listed on your account is: " + "$" + useR.getBalance() + "\n");
			return useR;
		}
		
		static User withdrawMoney(User client) {
			System.out.println("Because of the increase in scams out here, I'm logging you out after you withdraw your money bro.\n");
			System.out.println("How much would you trying to take? \n");
			double withdraw = keyboard.nextDouble();
			if(withdraw > client.getBalance()) {
				System.out.println("Don't play yourself. You know you only got $" + client.getBalance() + " in your account.\n" + "Get your money up and then try that.\n" 
			    + "We don't trust these scammers, so I'm logging you out.\n\n");
				return client;
			}
			User useR = service.getUser(client.getUserName());
		//	System.out.println("Balance in withdraw money method is : " + useR.getBalance()); //debugging purpose
		//	System.out.println("Username in the withdraw money method: " + useR.getUserName()); //debugging
			useR = service.updateBalance(useR, withdraw);
			useR = service.getUser(client.getUserName());
			System.out.println("You balance after your withdrawal is: " + useR.getBalance());
			return useR;
		}
		static User homeScreen(User client) {
			User useR = client;
		//	System.out.println("User info is: " + useR.getFirstName() + useR.getLastName() + useR.getUserName());
			System.out.println("To view your balance, enter (1), to deposit money, enter (2), to withdraw money, enter (3), or to log out, enter (4).\n");
			String input = keyboard.nextLine();
			switch(input) {
				case "1":
					viewBalance(client);
					homeScreen(useR);
					break;
				case "2":
					useR = depositMoney(client);
					run();
					break;
				case "3":
					withdrawMoney(client);
					run();
					break;
				case "4":
					System.out.println("Thank you for Banking with Felix! Enjoy your day!\n");
					run();
					break;
				default:
					System.out.println("Incorrect entry, please try again.");
					homeScreen(client);
			}
		//	System.out.println("Returning user is: " + useR.getFirstName() + useR.getLastName()+ useR.getUserName());
			return useR;
			
		}
		static User login() {
			User client = new User();
			System.out.println("Enter you username");
			client.setUserName(keyboard.nextLine());
			System.out.println("Enter your password");
			client.setPassWord(keyboard.nextLine());
			client = service.login(client);
		//	System.out.println("User name is: " + client.getUserName());
			if(client.getUserName().equals("null")) {
				run();
			}
			return client;
	}

	static User createAccount() {
		System.out.println("Ayeeeee! Welcome my guy! Enter your first name");
		User client = new User();
		client.setFirstName(keyboard.nextLine());
		System.out.println("Enter your last name");
		client.setLastName(keyboard.nextLine());
		System.out.println("Enter your desired userName");
		client.setUserName(keyboard.nextLine());
		System.out.println("Enter your password");
		client.setPassWord(keyboard.nextLine());
		System.out.println("How much would you like to deposit?");
		client.setBalance(keyboard.nextDouble());
		service.addUser(client);
		return client;
	}
	
	
	
}
