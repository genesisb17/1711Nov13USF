package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	
	static Service service = new Service();
	
	public static void main(String[] args) {
		run();
		
	} //end of main()



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

	static void createAccount() {
		
		User u = new User();
		System.out.print("Let's get started on making your account! Enter your first name: ");
		Scanner scan = new Scanner(System.in);	
		String uNameCheck;
		String read = scan.nextLine();
		u.setFirstName(read);
		
		System.out.print("Now enter your last name: ");
		read = scan.nextLine();
		u.setLastName(read);
		
		System.out.print("Enter your desired username: ");
		uNameCheck = scan.nextLine();
		u.setUserName(uNameCheck);
		
		System.out.print("Enter your password: ");
		read = scan.nextLine();
		u.setPassword(read);
		u.setBalance(0.00);
		service.addUser(u,uNameCheck);
		
		run();

	}

	static void login() {
		
		User u = new User();
		
		System.out.print("Enter your username: ");
		Scanner scan = new Scanner(System.in);		
		String user = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();
		boolean check;
		check = service.getUser(user, password);
		//scan.close();
		u = service.getUser(user);
		
		if(check == false) {
			System.out.println("Login failed. Make sure all information was entered correctly.\n");
			run();
		}
		
		else {

			System.out.println("Log in successsful!");
			
			
			boolean stop = false;
			while(stop != true) {
				
				System.out.println("What would you like to do? (1) to deposit, (2) to withdraw, or (3) to view your balance,"
						+ ", (4) create another account or (5) to exit:");
				Scanner scan2 = new Scanner(System.in);		
				String read = scan2.nextLine();
				
				switch(read) {
				
				case "1": deposit(u); break;
							
				case "2": withdraw(u); break;
				
				case "3": viewBalance(u); break;
				
				case "4":createOtherAccount(u); break;
				
				case "5": 
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



	static void createOtherAccount(User u) {
		
		//int id = -99;
		// function to get id of user
		//id = service.lookUpID(u);
		service.createAnotherAccount(u);
		
	}



	static void viewBalance(User u) {
	
		System.out.println("Here is your current balanace: ");
		service.viewBalance(u);
		
	}



	static void withdraw(User u) {
		
		System.out.print("Enter how much you want to withdraw (in $x.xx format): ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		System.out.print("Which account do you want to withdraw from? ");
		System.out.println("(View balance to see accounts for your username) ");
		int acc = sc.nextInt();
		service.withdraw(u,amount,acc);
		
	}



	static void deposit(User u) {
		
		System.out.print("Enter how much you want to deposit (in $x.xx format): ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		System.out.print("Which account do you want to deposit to? ");
		System.out.println("(View balance to see accounts for your username) ");
		int acc = sc.nextInt();
		service.deposit(u,amount,acc);
		
	}


		
} //end of RunBank class