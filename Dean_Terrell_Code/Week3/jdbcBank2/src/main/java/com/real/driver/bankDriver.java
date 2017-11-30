package com.real.driver;

import java.util.Scanner;

import com.real.pojos.User;
import com.real.util.Service;

public class bankDriver {

	static Service service = new Service(); 
	public static void main(String[] args) {
		run();
	}
	
	static void run() {
		
		Scanner scan = new Scanner(System.in);
		String op;
		do {
			System.out.println("Welcome to Dean Bank! Would you "
					+ "like to:\nLog in(1)\nCreate Account(2)\nExit(3)");
			op = scan.nextLine();
			switch(op) {
			case "1": login();
				break;
			case "2": createAccount();
				break;
			case "3": System.out.println("\nGoodbye!");
				break;
			default: System.out.println("Invalid option.\n");
			}
		} while(!op.equals("3"));
		scan.close();
	}
	
	static User login() {
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		String op;
		User u = new User();
		do {
			System.out.println("Please enter your username: ");
			op = scan.nextLine();
			u.setuName(op);
			if(!service.isUser(op)) {
				System.out.println("Username does not exist.");
				flag = true;
			}
			else
				flag = false;
		} while(flag);
		
		u = service.getUser(op);
		
		do {
			System.out.println("Please enter your password: ");
			op = scan.nextLine();
			if(!u.getPassword().equals(op)) {
				System.out.println("Invalid password. Please try again.");
				flag = true;
			}
			else
				flag = false;
		} while(flag);
	
		do {
			System.out.printf("\n\nWelcome %s! Would you like to:\n\nView your balance(1)\nDeposit(2)\nWithdraw(3)\nLog out(4)", u.getfName());
			op = scan.nextLine();
			switch(op) {
			case "1": System.out.printf("\nYour balance is $%.2f", u.getBalance());
				break;
			case "2": System.out.println("Please enter the amount you wish to deposit: ");
				op = scan.nextLine();
				double d = Double.parseDouble(op);
				service.updateBalance(u, u.getBalance() + d);
				u.setBalance(u.getBalance() + d);
				System.out.printf("\n$%.2f added to your account.", d);
				break;
			case "3": System.out.println("Plese enter the amount you wish to withdraw: ");
				op = scan.nextLine();
				double g = Double.parseDouble(op);
				service.updateBalance(u, u.getBalance() - g);
				u.setBalance(u.getBalance() - g);
				System.out.printf("\n$%.2f withdrawn from account.", g);
				break;
			case "4": System.out.println(); break;
			default: System.out.println("Invalid option.");
			}
		} while(!op.equals("4"));
		
		return null;
	}
	
	static User createAccount() {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		String temp;
		boolean flag = false;
		System.out.println("Welcome to account creation! ");
		
		do {
			System.out.println("\nPlease choose a username: ");
			temp = sc.nextLine();
			if(service.isUser(temp)) {
				System.out.println("Username already exists.");
				flag = true;
			}
			flag = false;
		} while(flag);
		
		u.setuName(temp);
		
		System.out.println("Please enter your first name: ");
		temp = sc.nextLine();
		u.setfName(temp);
		
		System.out.println("Please enter your last name: ");
		temp = sc.nextLine();
		u.setlName(temp);
		
		System.out.println("Please set a password for this account: ");
		temp = sc.nextLine();
		u.setPassword(temp);
		
		service.addUser(u);
		return null;
	}

}