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
		System.out.println("Welcom to WorthBank\nWould you"
				+ "like to log in(1) or Create Account(2)");
		
		//be sure to close scanners
		Scanner scan = new Scanner(System.in);
		//temporary
		scan.close();
		String op = scan.nextLine();
		switch(op) {
		case "1": 
		case "2": createAccount(); break;
		default: run();
		}
	}
	
	static User login() {
		return null;
	}
	
	static User createAccount() {
		System.out.println("Awesome! Welcome! Please Enter your first name.");
		User u=new User();
		u.setFirstname("Gen");
		u.setLastname("Bonds");
		u.setUsername("username");
		u.setPassword("pass");
		//deposit $$
		u.setBalance(1000000.00);
		service.addUser(u);
		return null;
	}
}
