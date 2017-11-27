package com.ex.test;



import java.util.Scanner;
import com.ex.pojos.User;
import com.ex.service.Service;

public class MainTest {

static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while (true)
			run();
	}
	static void run() {
		Service service = new Service();
		User use = new User();
		System.out.println("Welcome to bankware \nWould you like to log in (1) or create account(2)  quit (3)");
		String op = scan.nextLine();
		// validation
		switch (op) {
		case "1":
			use=service.login(scan);
			userMenu(use);
			break;
		case "2":
			if(service.addUser(scan))
				System.out.println("Account created successfully, please login");
			else
				System.out.println("Account was not created Successfully please try again.");
			break;
		case "3":
			System.out.println("Thank you for choosing bankware");
			System.exit(0);
			break;

		default:
			run();
		};
	}
	
	static void userMenu(User u) {
		Service service = new Service();
		System.out.println("Welcome " + u.getName()
				+ " \nWould you like to \n Check balance (1) \n Deposit(2)\n Withdraw(3) \n Log out(4)");

		String op = scan.nextLine();
		double hold = 0;
		switch (op) {
		case "1":
			System.out.println("Your current balance is: " + service.getAccount(u).getBalance() );
			userMenu(u);
			break;
		case "2":
			System.out.println("Enter amount to deposit");
			hold = Double.valueOf(scan.nextLine());
			if(hold<0)
				hold=0;
			service.updateBal(service.getAccount(u), hold + service.getAccount(u).getBalance());
			userMenu(u);
			break;
		case "3":
			System.out.println("Enter amount to withdraw, cannot exceed " + service.getAccount(u).getBalance());
			hold = Double.valueOf(scan.nextLine());
			if (hold > service.getAccount(u).getBalance()) {
				System.out.println("INVALID AMOUNT");
				userMenu(u);
			}
			if(hold<0)
				hold=0;
			service.updateBal(service.getAccount(u), service.getAccount(u).getBalance() - hold);
			userMenu(u);
			break;
		case "4":
			System.out.println("Thank you for banking with us, have a good day!");
			System.exit(0);
			break;
		default:
			userMenu(u);
		}
		;
	}

}
