package com.rev.run;
import java.util.ArrayList;
import java.util.Scanner;
import com.rev.service.Service;

public class RunErs 
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
		System.out.println("Ready");
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to login or are you a new user");
		int x;
		
		x = sc.nextInt();
		if(x==1)
		{
			System.out.println("Please enter username");
			String user = "p";
			System.out.println("Please enter password\n");
			String pass ="p";
			System.out.println(user +" ");
			int u_id = service.geters_users(user, pass);
			if(u_id!=0)
			{
				System.out.println("congrats it works");
			}
		}
		else
		{
			createAccount();
		}
		run();
	}
	static void createAccount()
	{
		String user,pass,email,first,last;
		Scanner sc = new Scanner(System.in);
		System.out.println("what is your new username");
		user = sc.nextLine();
		System.out.println("what is your password");
		pass = sc.nextLine();
		System.out.println("Firstname");
		first = sc.nextLine();
		System.out.println("Lastname");
		last = sc.nextLine();
		System.out.println("email?");
		email =sc.nextLine();
		service.adders_users(user, pass, first, last, email);
	}
}