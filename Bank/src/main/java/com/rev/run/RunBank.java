package com.rev.run;

import java.util.Scanner;

import com.rev.pojo.newUser;
import com.rev.service.Service;

public class RunBank 
{
	static Service service = new Service();
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		run();
		
	}
	static void run()
	{
		System.out.println("Welcome to BondsBank\nWould you like to Log in(1) or Create Account(2)");
		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		newUser u = new newUser();
		switch(op)
		{
		case "1":
			lookup();
		case "2":
			createAccount();
			break;
		case "3":
			break;
		default:
			run();
			break;
		}
		
	}
	static newUser login()
	{
		return null;
	}
	static void update()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("string you want updated");
		System.out.println("string you want to change to");
		String s = sc.nextLine();
		
	}
	static newUser createAccount()
	{
		System.out.println("awesome welcome");
		newUser u = new newUser();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is your first name?");
		String name;
		name = sc.nextLine();
		u.setFirstname(name);
		
		System.out.println("What is your last name?");
		name = sc.nextLine();
		u.setLastname(name);
		
		System.out.println("What is your username?");
		name = sc.nextLine();
		u.setUsername(name);
		
		System.out.println("What is your password?");
		name = sc.nextLine();
		u.setPassword(name);
		
		int x;
		x = sc.nextInt();
		u.setBalance(x);
		service.addUser(u);
		return u;
	}
	static newUser lookup()
	{
		System.out.println("What is username??");
		newUser u = new newUser();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("what is your password??");
		String pass = sc.nextLine();
		u = service.getUser(s,pass);
		System.out.println("Hello "+u.getFirstname());
		System.out.println("what do you want to look for? 1-balance");
		int x = sc.nextInt();
		switch(x)
		{
		case 1:
			System.out.println("Your balance is "+u.getBalance());
			break;
		}
		return u;
		
	}
}