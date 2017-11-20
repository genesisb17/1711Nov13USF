package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class bankDriver {

	static Service service = new Service(); 
	public static void main(String[] args) {
		run();
	}
	
	static void run() {
		System.out.println("Welcome to Dean Bank! Would you "
				+ "like to:\nLog in(1)\nCreate Account(2)\nExit(3)");
		
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch(op) {
		case "1": login();
			break;
		case "2": createAccount();
			break;
		case "3": System.out.println("Goodbye!");
			break;
		default: System.out.println("Invalid option.\n");
			run();
		}
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
			if(!service.isUser(u)) {
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
			System.out.printf("Welcome %s! Would you like to:\nView your balance(1)\nDeposit(2)\nWithdraw(3)\nLog out(4)", u.getfName());
			op = scan.nextLine();
			switch(op) {
			case "1": System.out.printf("\nYour balance is $%.2f\n\n", u.getBalance());
				break;
			case "2": System.out.println("Plese enter the amount you wish to deposit: ");
				op = scan.nextLine();
				double d = Double.parseDouble(op);
				u.setBalance(d + u.getBalance());
				System.out.printf("\n$%.2f added to your account.\n", d);
				d += u.getBalance();
				service.updateBalance(u.getBalance(), d);
				break;
			case "3": System.out.println("Plese enter the amount you wish to withdraw: ");
				op = scan.nextLine();
				double g = Double.parseDouble(op);
				u.setBalance(u.getBalance() - g);
				System.out.printf("\n$%.2f withdrawn from account.\n", g);
				g = u.getBalance() - g;
				service.updateBalance(u.getBalance(), g);
				break;
			case "4": break;
			default: System.out.println("Invalid option.\n");
			run();
			}
		} while(!op.equals("4"));
		
		scan.close();

		
		return null;
	}
	
	static User createAccount() {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		String temp;
		
		System.out.println("Welcome! Please enter your first name: ");
		temp = sc.nextLine();
		u.setfName(temp);
		
		System.out.println("Please enter your last name: ");
		temp = sc.nextLine();
		u.setlName(temp);
		
		System.out.println("Please choose a username: ");
		temp = sc.nextLine();
		u.setuName(temp);
		
		System.out.println("Please set a password for this account: ");
		temp = sc.nextLine();
		u.setPassword(temp);
		
		u.setBalance(0.00);
		service.addUser(u);
		
		sc.close();
		
		return null;
	}

}
