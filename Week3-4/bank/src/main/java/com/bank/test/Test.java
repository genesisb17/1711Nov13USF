package com.bank.test;

import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class Test {

	
	static Service service = new Service();

	public static void main(String[] args) {

		User u = start();
		System.out.println(u.toString());
		System.out.println("Welcome " + u.getFirstname());
		menu(u);

	}

	static void menu(User u){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("--Main Menu--");
		System.out.println("1. View Accounts\n2. Deposit\n"
				+ "3. Withdraw\n4. Transfer Funds\n5. Create Accounts"
				+ "\n6. Logout");

		Integer choice = Integer.parseInt(scan.next());
		switch(choice){
		case(1) : { // view // get all accounts acct's by user

		}
		case(2): {

		}
		
		}

	}

	static User start(){
		@SuppressWarnings("resource")
		Scanner scan  = new Scanner(System.in);
		System.out.println("---Welcome User! How Can I Help You?---");
		System.out.println("1. Login \n2. Create Account");
		Integer choice = Integer.parseInt(scan.next());
		User u;
		switch(choice){
		case(1) : {
			u = login();
			return u;
		}
		case(2): {
		u = createUser();
		return u;}
		
		default: return null;}
	}

	static User createUser(){
		Scanner scan = new Scanner(System.in);
		User u = new User();
		System.out.println("Enter your email address");
		String email = scan.next();
		int valid = service.validateUser(email);
		if(valid > 0){
			System.out.println("That email address is taken! Please enter a new one");
			createUser();
		}
		else{
			System.out.println("Enter your first name");
			String fn = scan.next();
			System.out.println("Enter your last name");
			String ln = scan.next();
			System.out.println("Enter your password");
			String pass = scan.next();
			u.setEmail(email);
			u.setFirstname(fn);
			u.setLastname(ln);
			u.setPassword(pass);
			u = service.addUser(u);
		}

		return u;
	}

	static User login(){
		Scanner scan  = new Scanner(System.in);
		System.out.println("Enter your email address");
		User u = null;

		String email = scan.next();
		int id = service.validateUser(email);
		if(id < 0) {
			System.out.println("You are not a user. Please try again");
			login();
		}
		else{ // i am a user so get PW
			System.out.println("Enter your password");
			String pw = scan.next();
			
			u = service.login(id, pw);
			
			
			if (u == null) { 
				System.out.println("You have entered the wrong password");
				start();}
		}
		return u;
	}

}
