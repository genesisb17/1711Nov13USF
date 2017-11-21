package com.rev.run;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.dao.FileDAO;
import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {
	static String file = "src/main/resources/bank.txt";
	static Service service = new Service();

	public static void main(String[] args) {
		while(true) {
			run();
		}
	}

	// place this in method in case of error, the program does not exit
	static void run() {
		System.out.println("Welcomme to BondsBank\n Would you like to log in(1) or Create Account(2)");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1": login();
			break;
		case "2":
			User user = createAccount();
			break;
		default:
			run();
		}
	}

	static void login() {
		
		String username = "";
		String password = "";
		System.out.println("Please enter your Username and password to log in.");
		Scanner scan = new Scanner(System.in);
		username = scan.nextLine();
		password = scan.nextLine();
	
		String str = "";

		BufferedReader br;
		boolean found = false;
		try {
			br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
				String[] information = str.split(":");
				//user.setId(Integer.parseInt(information[0]));
				if(username.equals(information[3]) && password.equals(information[4])) {
					User user = new User(Integer.parseInt(information[0]), information[1], 
							information[2], information[3], information[4],
							Double.parseDouble(information[5]));
					found = true;
					userMenu(user);
				}		
			}
			if(!found)
				System.out.println("User not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void userMenu (User user) {
	
		System.out.println("Would you like to view balance(1), withdraw(2) or deposit(3)" + "?");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		switch(option) {
		case"1": System.out.println("Your current balance is: " + user.getBalance());
			userMenu(user);
		break;
		case"2": System.out.println("How much would you like to withdraw?");
			Scanner scan1 = new Scanner(System.in);
			String bal = "0.0";
			bal = scan1.nextLine();
			if(user.getBalance() > Double.parseDouble(bal)) {
				User use = new User();
				user.setBalance(user.getBalance() - Double.parseDouble(bal));
				service.callUpdate(user);
				
			}else {
				System.out.println("You do not have enough in your account.");
			}
				userMenu(user);
		break;
		case"3": System.out.println("How much would you like to deposit?");
			Scanner scan11 = new Scanner(System.in);
			bal = "0.0";
			bal = scan11.nextLine();
			user.setBalance(user.getBalance() + Double.parseDouble(bal));
			service.callUpdate(user);
			userMenu(user);
		}
		
	}

	static User createAccount() {
		
		System.out.println("Welcome! Please enter your first name");
		int id = 0;
		String info = "";
		Scanner scan = new Scanner(System.in);
		info = scan.nextLine();
		User u = new User();
		
		u.setFirstname(info);
		
		System.out.println("Please enter your last name");	
		info = scan.nextLine();
		u.setLastname(info);
		
		System.out.println("Create a username for log in");
		info = scan.nextLine();
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream(file)).useDelimiter(":");
			while(scanner.hasNext()) {
			if(scanner.next().equals(info)) {
				System.out.println("This username already exists. Please start over.");
				run();
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		u.setUsername(info);
		
		
		System.out.println("Create a password for log in.");
		info = scan.nextLine();
		u.setPassword(info);
		
		//deposit $$
		u.setBalance(0);
		System.out.println("Your account has been created.");
		service.addUser(u);
		return u;
	}
	
	
}










