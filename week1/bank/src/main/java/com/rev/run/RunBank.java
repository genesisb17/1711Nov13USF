package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();
	static Scanner in=new Scanner(System.in);

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		User u=new User();
		System.out.println("\nWelcome to WorthBank! Would you like to... ");
		System.out.println("Log in (1)");	  
		System.out.println("Create Account (2)");


		String op = in.nextLine();
		switch(op) {
		case "1": 
			u=login();
			break;
		case "2": 
			u=createAccount(); 
			run();
			break;
		default: run();
		}

		if(!u.getUsername().equals("")){
			System.out.println("Welcome "+u.getFirstname()+". Would you like to ...");
			System.out.println("View balance (1)");
			System.out.println("Make a deposit (2)");
			System.out.println("Make a withdrawal (3)");
			String subOp=in.nextLine();
			switch(subOp) {
			case "1":
				view(u);
				run();
				break;
			case "2":
				double depBal=deposit(u);
				System.out.println("Your new balance is $"+depBal);
				run();
				break;
			case "3":
				double withBal=withdraw(u);
				System.out.println("Your new balance is $"+withBal);
				run();
				break;
			default:
				break;
			}
		}
	}

	static User login() {
		User u=new User();

		System.out.println("Input username: ");
		String user=in.nextLine();
		System.out.println("Input password: ");
		String pass=in.nextLine();
		u=service.validateLogin(user,pass);

		return u;
	}

	static User createAccount() {

		int id=0;
		System.out.println("Awesome! Welcome! Please Enter your first name:");
		String fn=in.nextLine();
		System.out.println("Please enter your last name:");
		String ln=in.nextLine();
		System.out.println("Please enter a username:");
		String user=in.nextLine();
		while(user.equals("")) {
			System.out.println("Please enter a username:");
			user=in.nextLine();
		}
		System.out.println("Please enter a password:");
		String pass=in.nextLine();
		System.out.println("Please enter the amount you would like to deposit: ");
		double bal=in.nextDouble();
		User u=new User(id,fn,ln,user,pass,bal);
		service.addUser(u);
		return u;

	}

	static void view(User u) {
		System.out.println("Your account balance is $"+u.getBalance());
		
		//put user back into the database
		service.updateUser(u);
	}

	static double deposit(User u) {
		double bal=u.getBalance();

		System.out.println("Input the amount to deposit: ");
		double dep=in.nextDouble();
		bal+=dep;
		u.setBalance(bal);
		
		//put user back into the database
		service.updateUser(u);

		return bal;
	}

	static double withdraw(User u) {
		double bal=u.getBalance();

		System.out.println("Input the amount to withdraw: ");
		double with=in.nextDouble();
		if(bal-with<0) {
			while(bal-with<0) {
				System.out.println("Cannot withdraw that amount.");
				System.out.println("Input the amount to withdraw: ");
				with=in.nextDouble();
			}
			
			bal-=with;
			u.setBalance(bal);
	
			//put user back into the database
			service.updateUser(u);
		} else {
			bal-=with;
			u.setBalance(bal);
			
			//put user back into the database
			service.updateUser(u);
		}

		return bal;
	}
}
