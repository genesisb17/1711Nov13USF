package com.revature.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.revature.dao.DAO;
import com.revature.dao.FileDAO;
import com.revature.main.BankDriver;
import com.revature.pojo.User;

public class Service {
	
	static DAO dao = new FileDAO();
	BankDriver reset = new BankDriver();
	public User addUser(User u){
		//validate that username does not exist 
		// assuming that it DNE:
		if(dao.getUser().contains(u.getUsername())) {
			System.out.println("Username is already taken. Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}
		
		dao.addUser(u);
		
		System.out.println("Congratulations! You created an account.");
		System.out.println("Your initial balance is $" + u.getBalance() + ".");
		return u;
	}
	
	
	public User logIn(User u) {
		
		ArrayList<String> result = new ArrayList<>();
		result = dao.logOn(u.getUsername(), u.getPassword());
		if(!(dao.getUser().contains(u.getUsername()))) {
			System.out.println("Username does not exist! Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}

		if(result == null) {
			System.out.println("Username/Password mismatch. Please try again.");
			System.out.println("--------------------------------------------");
			reset.run();
			return null;
		}
		
		System.out.println();
		System.out.println("Login Success!");
		System.out.println();
		transac(u, result);
		return u;
	}
	
	public User transac(User u, ArrayList<String> arr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome " + arr.get(0) + "!");
		System.out.println();
		System.out.println("Do you want to EXIT(1), DEPOSIT(2), WITHDRAW(3) or VIEW BALANCE(4)?");
		System.out.println();
		String lo = scan.nextLine();
		switch(lo) {
		case "1":
			System.out.println("Goodbye!");
			break;
		case "2":
			depo(u, arr);
			break;
		case "3":
			with(u, arr);
			break;
		case "4":
			double bal = Double.parseDouble(arr.get(4));
			System.out.println("Balance: $" + bal);
		default:
			transac(u, arr);
		}
		
		return u;
		
	}


	private void with(User u, ArrayList<String> userInfo) {
		// TODO Auto-generated method stub
		
	}


	private void depo(User u, ArrayList<String> uInfo) {
		// TODO Auto-generated method stub
		
	}

}