package com.rev.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.dao.DAO2;
import com.rev.dao.DAO2Impl;
import com.rev.pojos.BankAccount;
import com.rev.pojos.User2;

public class Service {
	
	//static D dao = new FileDao();
	static DAO2 dao = new DAO2Impl();

	public User2 getUserByUnameAndPassword(String userName, String password) {
		
		User2 u = dao.getUserByUnameAndPassword(userName, password);
		
		return u;
		
	}

	public ArrayList<BankAccount> getAccounts(User2 user) {
		return dao.getUsersBankAccounts(user);		
	}

	public double makeDeposit(BankAccount bankAccount, double amount) {
		double balance = bankAccount.getBalance() + amount;
		System.out.println("Initial balance: " + bankAccount.toString());
		dao.adjustBalance(bankAccount, balance);
		System.out.println("Did it change: " + 
				dao.getBankAccountById(bankAccount.getAccountID()).toString()); 
		return 0;
	}

	public double makeWithdrawal(BankAccount bankAccount, double amount) {
		double balance = bankAccount.getBalance() - amount;
		System.out.println("Initial balance: " + bankAccount.toString());
		dao.adjustBalance(bankAccount, balance);
		System.out.println("Did it change: " + 
				dao.getBankAccountById(bankAccount.getAccountID()).toString()); 
		return 0;
	}

	public void getUsers() {
		ArrayList<User2> usrs =	dao.getUsers();
		for(User2 u: usrs) {
			System.out.println(u.toString());
		}
		
	}

	public User2 addUser() {
		System.out.println("Welcome. Please enter your first name");
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		System.out.println("Please enter your last name.");
		String lastName = scan.next();
		String userName = inuptUsername(scan);
		
		System.out.println("Please enter your password.");
		String password = scan.next();
		User2 usr = new User2(firstName, lastName, userName, password);
		
		User2 user = dao.createUserAccount(usr);
		this.createBankAccount(user.getUid());
		return user;		
	}

	private String inuptUsername(Scanner scan) {
		System.out.println("Please enter your username.");
		String userName = scan.next();
		User2 checkUser = dao.getUserByUname(userName);
		if (checkUser.getUid() != 0) {
			System.out.println("I'm sorry, this username already exists. Try again.");
			userName = inuptUsername(scan);
		}
		
		return userName;
	}

	public BankAccount createBankAccount(int uid) {
		
		System.out.println("Please enter your enter your inital balance.");
		Scanner scan = new Scanner(System.in);
		int balance = Integer.parseInt(scan.next());
		BankAccount account = new BankAccount(uid, balance);
		return dao.createBankAccount(account);
		
	}

	public ArrayList<BankAccount> getBankAccountsByUser(int userID) {
		User2 user = new User2();
		user.setUid(userID);
		return dao.getUsersBankAccounts(user);
	}
	
	public void test() {
		System.out.println("This is a test");
	}

}
