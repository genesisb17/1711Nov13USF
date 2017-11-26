package com.bank.main;

import java.util.Scanner;

//import com.bank.pojos.Users;
import com.bank.services.Services;

public class MainDriver {
	
	public static void main(String[] args) {
		
		run();
		
	}

	public static void run() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to DE Bank!");
		System.out.println("Would you like to CREATE(1) an account, LOGIN(2) or \n"
				+ "EXIT(3)?");
		Services serv = new Services();
		Scanner in = new Scanner(System.in);
		String op = in.nextLine();
		switch(op) {
		case "1":
			serv.addaUser();
			run();
			break;
		case "2":
			serv.logIn();
			run();
			break;
		case "3":
			System.out.println("Goodbye!");
			break;
		default:
			run();
			break;
		}
	}
}
