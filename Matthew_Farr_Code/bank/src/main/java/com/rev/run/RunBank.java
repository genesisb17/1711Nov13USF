package com.rev.run;

import java.math.BigDecimal;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();

	public static void main(String[] args) {
		run();
	}

	static void run(){
		System.out.println("Welcome to Bank of Falador\nWould you like to\n(1) Log in \nOR \n(2) "
							+ "Create Account");
		Scanner scanner = new Scanner(System.in);
		String op = scanner.nextLine();
		switch(op){
		case "1": 
			User u = login(scanner);
			accountOperations(scanner, u);
			run();
			break;
		case "2": 
			createAccount(scanner);
		default: run();
		}
		
		scanner.close();
	}
	
	static User accountOperations(Scanner scanner, User u) {
		
		System.out.println("Welcome to your account\nWold you like to\n(1)Deposit\n(2)Withdraw\n"
							+ "OR\n(3)View Balance");
		String op = scanner.nextLine();
		switch(op) {
		case "1":
			System.out.println("Excellent! Please enter an amount to deposit: ");
			BigDecimal deposit = scanner.nextBigDecimal();
			u.setBalance(u.getBalance().add(deposit));
			service.updateUser(u);
			System.out.println("Updated balance: " + u.getBalance());
			break;
		case "2":
			System.out.println("Please enter an amount to withdraw: ");
			BigDecimal withdraw = scanner.nextBigDecimal();
			u.setBalance(u.getBalance().subtract(withdraw));
			u = service.updateUser(u);
			if (u != null)
				System.out.println("Updated balance: " + u.getBalance());
			else
				System.out.println("There was an error updating your balance. Balance cannot be negative.");
			break;
		case "3":
			System.out.println("Current balance: " + u.getBalance());
			break;
		default:
			System.out.println("Invalid Operation. Logging out."); 
			break;
		}
		
		return u;
	}

	static User login(Scanner scanner){
		System.out.println("Please enter the username for your account: ");
		User u = service.getUser(scanner.nextLine().trim());
		if (u == null) {
			System.out.println("Username does not exist\n");
			return null;
		}
		System.out.println("Please enter the password for your account: ");
		String pw = scanner.nextLine();
		if (!pw.equals(u.getPassword())) {
			System.out.println("Passwords do not match");
			return null;
		}
		System.out.println("Login successful! Here are your account details: ");
		System.out.println(u.toConsole());
		return (u);
	}

	static User createAccount(Scanner scanner){
		User u = new User();
		
		System.out.println("Greetings new customer! Please Enter your first name:");
		u.setFirstname(scanner.nextLine().trim());
		System.out.println("Please enter your last name:");
		u.setLastname(scanner.nextLine().trim());
		System.out.println("Welcome to the Bank of Falador, " + u.getFirstname() + " " + u.getLastname() + "!");
		System.out.println("Please enter your new username: ");
		u.setUsername(scanner.nextLine().trim());
		System.out.println("Your new username is " + u.getUsername());
		System.out.println("Please set a password: ");
		u.setPassword(scanner.nextLine());
		System.out.println("Please enter your initial deposit: ");
		u.setBalance(scanner.nextBigDecimal());
		service.addUser(u);
		return u;
	}

}
