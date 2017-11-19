package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;

import come.rev.service.Service;

public class RunBank {

	static Service service = new Service();
		
	public static void main(String[] args) {
		
		run();
		
	}
	
	static void run() {
		System.out.println("Welcome to BondsBank\n Would you like to Log in(1) or Create an Account(2)?");
		
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch(op) {
		case 1: login();
		case 2: createAccount(); break;
			default: run();
		}
		
	}
	
	static User login() {
		return null;
	}
	
	static User createAccount() {
		System.out.println("Awesome! Welcome!. Please enter your first name: ");
		User u = new User();
		u.setFirstname("Gen");
		u.setLastname("Bonds");
		u.setUsername("username");
		u.setPassword("pass");
		// deposit $$
		u.setBalance(100000000.0+"");
		service.addUser(u);
		return null;
	}
	

}
