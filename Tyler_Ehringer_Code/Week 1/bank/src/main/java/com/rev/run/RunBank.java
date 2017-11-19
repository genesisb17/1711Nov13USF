package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.ConsoleHandler;
import com.rev.service.Service;

public class RunBank implements Runnable{
	
	private ConsoleHandler con;
	private Service ser;
	
	public RunBank() {
		con = new ConsoleHandler(new Scanner(System.in));
		ser = new Service();
	}
	
	@Override
	public void run() {
		while(true) {
			boolean repeat;
			System.out.println("Welcome to the bank!");
			do {
				repeat = false;
				int response =  con.promptInt("Please make a selection:\n" + 
						"Login          - 1\n" + 
						"Create Account - 2");
				switch(response) {
				case 1: 
					login();
					break;
				case 2: 
					createUser();
					break;
				default:
					System.out.println("I'm sorry, that is not a valid input.");
					repeat = true;
					break;
				}
			}while(repeat == true);
		}
	}
	
	private void login() {
		String email, password;
		while(true) {
			email = con.promptString("Please enter your username/email:");
			if(ser.hasUser(email)) break;
			System.out.println("That did not match a valid usernam/email.");
		}
		User u = ser.getUser(email);
		while(true) {
			password = con.promptString("Please enter your password:");
			if(password.equals(u.getPassword())) break;
			System.out.println("Your password did not match.");
		}
		bankingOptions(u);
	}
	
	private void bankingOptions(User u) {
		boolean repeat;
		do {
			repeat = true;
			int response =  con.promptInt("What would you like to do?\n" + 
					"Make a deposit    - 1\n" + 
					"Make a withdrawal - 2\n" + 
					"View balance      - 3\n" + 
					"Exit              - 4");
			switch(response) {
			case 1: 
				u = deposit(u);
				break;
			case 2: 
				u = withdraw(u);
				break;
			case 3:
				viewBalance(u);
				break;
			case 4:
				repeat = false;
				break;
			default:
				System.out.println("I'm sorry, that is not a valid input.");
				break;
			}
		}while(repeat);
	}
	
	private User deposit(User u) {
		double deposit;
		while(true) {
			viewBalance(u);
			deposit = con.promptDouble("How much would you like to deposit?");
			if(deposit >= 0.0f) break;
			System.out.println("You cannot deposit a negative amount of money.");
		}
		System.out.printf("You have deposited $%.2f.\n", deposit);
		u = ser.addToBalance(u, deposit);
		viewBalance(u);
		return u;
	}
	
	private User withdraw(User u) {
		double withdrawal;
		while(true) {
			viewBalance(u);
			withdrawal = con.promptDouble("How much would you like to withdraw?");
			if(withdrawal <= u.getBalance()) break;
			System.out.println("That is more than your current balance.");
		}
		System.out.printf("You have withdrawn $%.2f.\n", withdrawal);
		u = ser.addToBalance(u, -withdrawal);
		viewBalance(u);
		return u;
	}
	
	private void viewBalance(User u) {
		System.out.printf("Your current balance is $%.2f.\n", u.getBalance());
	}
	
	private void createUser() {
		String email, password, firstName, lastName;
		while(true) {
			email = con.promptString("Please enter your desired username:");
			if(!ser.hasUser(email)) break;
			System.out.println("That username is already taken.");
		}
		while(true){
			password = con.promptString("Please enter your password:");
			if(password.equals(con.promptString("Please confirm your password:"))) break;
			System.out.println("Your passwords did not match");
		}
		firstName = con.promptString("Please enter your first name:");
		lastName = con.promptString("Please enter your last name:");
		bankingOptions(ser.addNewUser(email, password, firstName, lastName));
	}
	
	public static void main(String[] args) {
		new RunBank().run();
	}

}
