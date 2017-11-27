package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	
	static Service service = new Service();
	
	public static void main(String[] args) {
		run();
		
	}

	
	static void run() {
		
		System.out.println("Welcome to Alegria Banking\nWould you like to "
				+ "Log In (1) or Create Account(2), or (3) to exit");

		Scanner scan = new Scanner(System.in);		
		String op = scan.nextLine();
		
		switch(op) {
		
		case "1": login(); break;
					
			
		case "2": createAccount(); break;
		
		case "3": System.out.println("Goodbye!"); break;
			
		default: run();
			
		}
		
		
		
	}
	
	static void login() {
		
		System.out.print("Enter your username: ");
		Scanner scan = new Scanner(System.in);		
		String user = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();
		boolean check;
		check = service.getUser(user, password);
		//scan.close();
		
		if(check == false) {
			System.out.println("Make sure all information was entered correctly.\n");
			run();
		}
		
		else {

			System.out.println("Log in successsful!");
			
			boolean stop = false;
			while(stop != true) {
				
				System.out.println("What would you like to do? (1) to deposit, (2) to withdraw, or (3) to view your balance,"
						+ "or (4) to exit:");
				Scanner scan2 = new Scanner(System.in);		
				String read = scan2.nextLine();
				
				switch(read) {
				
				case "1": deposit(user); break;
							
				case "2": withdraw(user); break;
				
				case "3": viewBalance(); break;
				
				case "4": 
					stop = true;
					System.out.println("Goodbye!"); break;
					
				default: break;
					
				}
				
				
			    System.out.println("Would you like to continue? ('Yes' or 'No')");
			    String s = scan.nextLine();
			    if(s.equals("No") || s.equals("no")) {
			        stop = true;
			        System.out.println("Goodbye!");
			    }
			}
			
		}
		
	}
	
	static User createAccount() {
		
		User u = new User();
		System.out.print("Let's get started on making your account! Enter your first name: ");
		Scanner scan = new Scanner(System.in);	
		String read2;
		String read = scan.nextLine();
		u.setFirstName(read);
		
		System.out.print("Now enter your last name: ");
		read = scan.nextLine();
		u.setLastName(read);
		
		System.out.print("Enter your desired username: ");
		read2  = scan.nextLine();
		u.setUserName(read2);
		
		System.out.print("Enter your password: ");
		read = scan.nextLine();
		u.setPassword(read);
		u.setBalance(0.00);
		service.addUser(u,read2);
		
		run();
		return u;		
		
	}
	
	static void deposit(String user) {
		
		System.out.print("Enter how much you want to deposit (in $x.xx format): ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		service.deposit(amount,user);
		//service.updateBalance(temp,user);
		
	}
	
	static void viewBalance() {
		System.out.print("Here is how much is in your account: ");
		service.viewBalance();
		
	}
	
	static void withdraw(String user) {
		
		System.out.print("Enter how much you want to withdraw (in $x.xx format): ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		service.withdraw(amount,user);
		
	}
	
	
	
}
