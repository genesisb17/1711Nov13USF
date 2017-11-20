package com.rev.run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static Service service = new Service();
 public static void main(String[] args) {
	while(true)
	 run();
}
 static void run(){
	 System.out.println("Welcome to bankware \nWould you like to log in (1) or create account(2)");
		Scanner scan = new Scanner(System.in);
		String op= scan.nextLine();
		User u = new User();
		//validation 
		switch(op){
		case"1": login(); 
		break;
		case"2":createAccount();
		break;
		default: run();
		};
 	}
 
 static void userMenu(User u){

	 System.out.println("Welcome "+ u.getFirstName() +" \nWould you like to Check balance (1) \n Deposit(2)\n Withdraw(3) \n Log out(4)");
		Scanner scan = new Scanner(System.in);
		String op= scan.nextLine();
		double hold=0;
		//validation 
		switch(op){
		case"1": System.out.println("Your current balance is: "+ u.getBalance() );
				userMenu(u);
		break;
		case"2": System.out.println("Enter amount to deposit");
		hold = Double.valueOf(scan.nextLine());
		u=service.update(u.getUsername(), hold+u.getBalance());
		userMenu(u);
			break;
		case"3": System.out.println("Enter amount to withdraw, cannot exceed " + u.getBalance());
		hold = Double.valueOf(scan.nextLine());
		if (hold> u.getBalance())
		{
			System.out.println("INVALID AMOUNT");
			userMenu(u);
		}
		u=service.update(u.getUsername(), u.getBalance()-hold);
		userMenu(u);
			break;
		case"4":
			System.out.println("Thank you for banking with us, have a good day!");
			System.exit(0);
			break;
		default: userMenu(u);
		};
 }
 
		/*
	static User login(){
		return null;
	}
	*/
 	static void login(){
		//make sure this is unique , check the file for all usernames.
		//read in and PARSE IT IN OTHER WORDS AAAAAAA
 		Scanner in = new Scanner(System.in);
 		String userName, password;
		System.out.println("Please enter your username .......");
		userName = in.nextLine();
		System.out.println("Please enter your password .......");
		password =in.nextLine();
		try{ 
			String line;
			String[] limited;
			boolean check=false;
			FileReader  fr= new FileReader("src/main/resources/bank.txt");
			BufferedReader br= new BufferedReader (fr);
            while((line = br.readLine()) != null) {
            	limited=line.split(":");
            	if (limited[3].equals(userName) && limited[4].equals(password) )
            	{
            		System.out.println("Username and password accepted");
            		//br.close();
            		check=true;
            		User u = new User(Integer.valueOf(limited[0]),limited[1],limited[2],limited[3],limited[4],Double.valueOf(limited[5]));
            		userMenu(u);
            		
            		
            	}
            }
            if (check==false)
    		System.out.println("Sorry couldn't find username/password combination");
    		}catch(FileNotFoundException  ex)
    		{
    			ex.printStackTrace();
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		// need to make sure this fits certain criteria ofcourse, also need  password and username to be correct  
 		
 	}
	static User createAccount(){
		System.out.println("Please enter your first name .......");
		Scanner in = new Scanner(System.in);
		User u = new User();
		u.setFirstName(in.nextLine());
		System.out.println("Please enter your last name .......");
		u.setLastName(in.nextLine());
		//make sure this is unique , check the file for all usernames.
		//read in and PARSE IT IN OTHER WORDS AAAAAAA
		System.out.println("Please enter your username .......");
		String userAttempt = in.nextLine();
		try{ 
			String line;
			String[] limited;
			int idCheck=0;
			FileReader  fr= new FileReader("src/main/resources/bank.txt");
			BufferedReader br= new BufferedReader (fr);
            while((line = br.readLine()) != null) {
            	limited=line.split(":");
            	if (limited[3].equals(userAttempt))
            	{
            		System.out.println("Username not available");
            		br.close();
            		run();
            	}
            	idCheck=Integer.parseInt(limited[0]);
            }
    		u.setUsername(userAttempt);
    		u.setId(++idCheck);
    		br.close();
    		}catch(FileNotFoundException  ex)
    		{
    			ex.printStackTrace();
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
		// need to make sure this fits certain criteria ofcourse, also need  password and username to be correct 
		System.out.println("Please enter your password .......");
		u.setPassword(in.nextLine()); 
		// BE SURE TO PARSE DOUBLE BELOW
		System.out.println("Please enter your initial deposit amount .......");
		u.setBalance(Double.parseDouble((in.nextLine())));
		//deposit $$$
		//u.setBalance(100000.0);
		service.addUser(u);
		System.out.println(u);
		return u;
		
	}
 }

