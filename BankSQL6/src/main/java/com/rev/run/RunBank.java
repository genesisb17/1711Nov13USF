package com.rev.run;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojo.Account;
import com.rev.pojo.newUser;
import com.rev.service.Service;

public class RunBank 
{
	static Service service = new Service();
	static int id;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		run();
	}
	static void run()
	{
		System.out.println("Welcome to BondsBank\nWould you like to Log in(1) or Create User(2)");
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
		run();
	}
	static newUser login()
	{
		return null;
	}
	static void up(newUser u)
	{
		String old;
		String n;
		Scanner sc= new Scanner(System.in);
		System.out.println("what is the old string to replace??");
		old = sc.nextLine();
		System.out.println("what is then new String???");
		n = sc.nextLine();
		if(u.getFirstname().equals(old)||u.getLastname().equals(old)||u.getUsername().equals(old)||u.getPassword().equals(old))
		{
			service.change1(old, n,id);
		}
	}
	static void update()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("username??");
		String s = sc.nextLine();
		System.out.println("How much do you want to Deposit??");
		double u = sc.nextDouble();
		service.change(s, u,id);
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
		
		System.out.println("What is your amount you have?");
		double x;
		x = sc.nextDouble();
		u.setBalance(x);
		if(service.getUser(u.getUsername(), u.getPassword(),id).getBalance()==0)
		{
			service.addUser(u,id);
		}
		else
		{
			System.out.print("Sweet sisa frass User is already created. *0*\n");
		}
		return u;
	}
	static newUser lookup()
	{
		ArrayList<Account> a = new ArrayList<Account>();
		System.out.println("Welcome Please enter username for the account you want to look up??");
		newUser u = new newUser();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("what is your password??");
		String pass = sc.nextLine();
	
		u = service.getUser(s,pass,id);
		service.getArtbyid(u);
		System.out.println("what is the acc_id you want to use?? Note to create an ac");
		id =sc.nextInt();
		
		if(u.getFirstname()==null)
		{
			run();
		}
		System.out.println("Hello "+u.getFirstname());

		System.out.println("what do you want to look for? 1-balance 2-Deposit (Use - for withdraw) 5-create account ");
		int x = sc.nextInt();
		switch(x)
		{
			case 1:
				u = service.getUser(s,pass,id);
				System.out.println("Name: "+u.getFirstname()+" "+u.getLastname());
				System.out.println("username: "+u.getUsername());
				System.out.println("Your password is "+u.getPassword());
				System.out.println("Your balance is "+u.getBalance());
				break;
			case 2:
				update();
				break;
			case 3:
				service.change1(s, pass,id);
				break;
			case 4:
				id = sc.nextInt();
				break;
			case 5:
				System.out.println("balance?");
				double b = sc.nextDouble();
				
				service.createAccount(u, b, u.getId());
				break;
		}
		lookup();
		return u;
	}
}