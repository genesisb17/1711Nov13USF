package com.rev.run;

import java.util.Scanner;

import com.rev.service.Service;

public class RunBank {
	private static Service service = new Service();
	private static final Scanner in=new Scanner(System.in);

	public static void main(String[] args) {
		run();
	}

	public static void run() {

		System.out.println("\nWelcome to WorthBank! Would you like to... ");
		System.out.println("Log in (1)");	  
		System.out.println("Create User (2)");
		String op = in.nextLine();
		switch(op) {
		case "1": 
			login();
			break;
		case "2": 
			createUser(); 
			run();
			break;
		default: 
			run();
		}
	}
	
	public static void chooseAccount(String username) {
		String name=service.getNamefromUsername(username);
		System.out.println("Welcome "+name+". Choose one of the following: ");
		System.out.println("Make a new account (0)");
		int numAcc=service.numAccountsfromUsername(username);
		for(int i=0;i<numAcc;i++) {
			int accNo=i+1;
			System.out.println("Manage account "+accNo+" ("+accNo+")");
		}
		int subOp=in.nextInt();
		//get rid of \n character from input:
		in.nextLine();
		if (subOp==0) {
			createAccount(username);
		} else if (isBetween(subOp,1,numAcc)) {
			manageAccount(subOp, username);
		} else {
			chooseAccount(username);
		}

	}

	static void login() {
		System.out.println("Input your username: ");
		String username=in.nextLine();
		if (service.userExists(username)) {
			System.out.println("Input your password: ");
			String password=in.nextLine();
			if (service.passwordCorrect(username,password)) {
				chooseAccount(username);
			} else {
				System.out.println("Invalid password.");
			}
		} else {
			System.out.println("Invalid username.");
			run();
		}
	}

	public static void createAccount(String username) {
		System.out.println("What amount would you like for initial deposit?");
		double bal=in.nextDouble();
		service.addAccount(username,bal);
		run();
	}
	
	public static void manageAccount(int accNum,String username) {
		int accId=service.getAccIdInManage(username, accNum);
		System.out.println("What would you like to do with this account?");
		System.out.println("View Balance (1)");
		System.out.println("Make a Deposit (2)");
		System.out.println("Make a Withdrawal (3)");
		String op=in.nextLine();
		switch(op) {
		case "1":
			double bal =service.getBalanceByAccId(accId);
			System.out.println("The account balance is $"+bal);
			break;
		case "2":
			System.out.println("Input amount to deposit: ");
			double dep=in.nextDouble();
			//get rid of \n character from input:
			in.nextLine();
			while(dep<0) {
				System.out.println("Cannot deposit a negative amount.");
				System.out.println("Input amount to deposit: ");
				dep=in.nextDouble();
				//get rid of \n character from input:
				in.nextLine();
			}
			double afterDep=service.depositByAccId(dep, accId);
			System.out.println("The account's new balance: $"+afterDep);
			break;
		case "3":
			System.out.println("Input amount to withdraw: ");
			double with=in.nextDouble();
			//get rid of \n character from input:
			in.nextLine();
			double old=service.getBalanceByAccId(accId);
			while(old-with<0) {
				System.out.println("Amount requested is more than in account.");
				System.out.println("Input amount to withdraw: ");
				with=in.nextDouble();
				//get rid of \n character from input:
				in.nextLine();
			}
			double afterWith=service.withdrawByAccId(with, accId);
			System.out.println("The accounts new balance: $"+afterWith);
			
			break;
		default:
			manageAccount(accNum, username);
			break;
		}
		run();
	}
	
	public static void createUser() {
		System.out.println("Awesome! Welcome! Please Enter your first name:");
		String fn=in.nextLine();
		System.out.println("Please enter your last name:");
		String ln=in.nextLine();
		System.out.println("Please enter a username:");
		String username=in.nextLine();
		while(username.equals("")) {
			System.out.println("Either nothing was entered or user already exists.");
			System.out.println("Please enter a username:");
			username=in.nextLine();
		}
		System.out.println("Please enter a password:");
		String pass=in.nextLine();

		boolean added=service.addUser(fn,ln,username,pass);
		if(!added) {
			System.out.println("User already exists.");
			run();
		}
	}
		
	public static boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}

}
