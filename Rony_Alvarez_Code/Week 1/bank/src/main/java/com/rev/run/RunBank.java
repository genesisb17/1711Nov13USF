package com.rev.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {

	static Service service = new Service();
	static DAO dao = new FileDAO();
	
	public static void main(String[] args) {
		
		run();
		
	}
	
	static void run() {
		
		System.out.println("Welcome to JP Morgan Chase! \nWould you like to Log in(1), Register as a new user(2), or Exit(3)?");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		
		switch (op) {
			case "1":
				login();
				break;

			case "2":
				User newUser = newUserRegistration();
				dao.registerUser(newUser);
				run();
				break;
				
			case "3":
				System.exit(0);
				break;

			default:
				run();
		}		
				
	}
	
	static User login() {
		
		System.out.println("Please enter your username:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scan.nextLine();
		
		User user = dao.login(username, password);
		
		if(user.getFirstname() == null) {
			
			System.out.println("Incorrect username or password. \nWould you like yo try again(1) or exit(2)?");
			
			String tryAgain;
			@SuppressWarnings("resource")
			Scanner tryAgainScan = new Scanner(System.in);
			tryAgain = tryAgainScan.nextLine();
			
			if(tryAgain.equals("1")) {
			
				login();
			
			} else {
				
				System.out.println("Thanks fro chosing JP Morgan! Have a nice day.");
				System.exit(0);
			
			}		
			
		}
		
		System.out.println("Welcome back " + user.getFirstname() + "! How can we help you today?");
		System.out.println("Create Account(1), View Balance(2), Deposit Money(3), Withdraw Money(4), or Log Out(5)?");
		String op = scan.nextLine();
		
		switch(op) {
			case "1": 	
				System.out.println("Enter your inital balance:");
				Scanner initialBalance = new Scanner(System.in);
				String iniBalance = initialBalance.nextLine();
				dao.createAccount(user.getId(), Double.parseDouble(iniBalance));
				run();
				break;
				
			case "2": 
				dao.getBalance(user.getId()); 
				run();
				break;
			
			case "3": 
				ArrayList<User> currentAccounts = new ArrayList<>();
				currentAccounts = dao.getBalance(user.getId());
				
				System.out.println("Enter your account id:");
				String accountId = scan.nextLine();
				
				User balance = dao.getBalanceById(Integer.parseInt(accountId));
				
				System.out.println("How much money would you like to deposit?");
				String deposit = scan.nextLine();
				
				dao.depositMoney(Integer.parseInt(accountId), balance.getBalance(), Double.parseDouble(deposit));
				run();
				break;
				
			case "4":  
				ArrayList<User> currentAccountss = new ArrayList<>();
				currentAccountss = dao.getBalance(user.getId());
				
				System.out.println("Enter your account id:");
				String accountIdWD = scan.nextLine();
				
				User balanceWD = dao.getBalanceById(Integer.parseInt(accountIdWD));
				
				System.out.println("How much money would you like to withdraw?");
				String depositWD = scan.nextLine();
				
				dao.withdrawMoney(Integer.parseInt(accountIdWD), balanceWD.getBalance(), Double.parseDouble(depositWD));
				run(); 
				break;
				
			case "5": 
				System.out.println("Thank you for being a loyal customer! Have a nice day.");
				System.exit(0);
				break;
				
			default: 
				run(); 
		}
		
		
		return null;
	
	}
	
	static User createAccount() {
		
		User u = new User();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		String firstname = scan.nextLine();
		u.setFirstname(firstname);
		
		System.out.println("Please enter your last name: ");
		String lastname = scan.nextLine();
		u.setLastname(lastname);
		
		System.out.println("Please enter your username: ");
		String username = scan.nextLine();
		u.setUsername(username);
		
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		u.setPassword(password);
		
		System.out.println("Please enter your initial balance: ");
		double balance = Double.parseDouble(scan.nextLine());
		u.setBalance(balance);
		
		
		System.out.println("Account was created successfully!");
				
		
		service.addUser(u);
		return null;
	
	}
	
	static User newUserRegistration() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first name:");
		String firstname = scan.nextLine();
		
		System.out.println("Enter your last name:");
		String lastname = scan.nextLine();
		
		System.out.println("Enter your username:");
		String username = scan.nextLine();
		
		System.out.println("Enter your password:");
		String password = scan.nextLine();
		
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
	
	}
	
/*	
	public static void addMoney(String username, String password, String amount) {
		
		service.AddMoney(username, password, amount);
		
	}
	
	public static void viewBalance(String username, String password) {
		
		service.viewBalance(username, password);
		
	}
	
	public static void withdrawMoney(String username, String password, String amount) {
		
		service.withdrawMoney(username, password, amount);
		
	}*/
	

}
