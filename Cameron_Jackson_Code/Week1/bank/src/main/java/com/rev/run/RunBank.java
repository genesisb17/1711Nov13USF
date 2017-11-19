package com.rev.run;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class RunBank {

	static Service service = new Service();

	public static void main (String[] args) {
		run();
	}

	static void run() {
		System.out.println("Welcome to The Bank\nWould you like" 
				+ " to create an account(1) or login(2)?");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		User currentUser;
		switch (input) {
		case "1":
			createAccount(getNewUserInfo(scan), scan);
		case "2": 
			System.out.println("Login");
			System.out.println("=====");
			currentUser = login(getUserInfo(scan), scan);
			mainMenu(currentUser, scan);
			break;
		default: run();
		}
		scan.close();
	}
	
	static void printMenu(User u) {
		System.out.println("The Bank");
		System.out.println("========");
		System.out.println("User " + (1+u.getId()) + ": " + u.getFirstname() + " " + u.getLastname());
		System.out.println("What would you like to do?");
		System.out.println("View Balance(1)");
		System.out.println("Make Depsosit(2)");
		System.out.println("Make Withdrawal(3)");
		System.out.println("Logout and Exit(4)");
	}

	static void mainMenu(User u, Scanner scan) {
		printMenu(u);

		String op;
		do {
			System.out.println("Please make a selection: ");
			op = scan.nextLine();
			switch (op) {
			case "1":
				// view balance function
				System.out.println("View Balance");
				System.out.println("============");
				viewBalance(u);
				break;
			case "2":
				// make deposit function
				System.out.println("Deposits");
				System.out.println("========");
				depositFunds(u, scan);
				break;
			case "3":
				// make withdrawal function
				System.out.println("Withdrawals");
				System.out.println("===========");
				withdrawFunds(u, scan);
			case "4":
				// exit
				break;
			default:
				System.out.println("Not a valid option please enter another");
			} // END SWITCH
		} while (!op.equals("4")); // END WHILE
		System.out.println("Thank you for using The Bank. Have a nice day.");
	}

	static User getUserInfo(Scanner scan) {
		User u = new User();
		String uName, pass;

		System.out.println("Enter your username: ");
		uName = scan.nextLine();
		System.out.println("Enter your password: ");
		pass = scan.nextLine();

		u.setUsername(uName);
		u.setPassword(pass);

		return u;
	}

	static User getNewUserInfo(Scanner scan) {
		User u = new User();
		String fName, lName, uName, pass;

		System.out.println("Please enter your first name: ");
		fName = scan.nextLine();
		System.out.println("Enter your last name: ");
		lName = scan.nextLine();
		System.out.println("Enter your desired username: ");
		uName = scan.nextLine();
		System.out.println("Enter your desired password: ");
		pass = scan.nextLine();

		u.setFirstname(fName);
		u.setLastname(lName);
		u.setUsername(uName);
		u.setPassword(pass);

		return u;
	}

	static User login(User u, Scanner scan) {
		User cUser = service.login(u.getUsername(), u.getPassword());
		if (cUser == null) {
			System.out.println("Incorrect username or password. Please try again.");
			cUser = login(getUserInfo(scan), scan);
		}
		System.out.println("Login successful.\n");
		return cUser; // object referring to current user
	}

	static void createAccount(User u, Scanner scan) { 
		String uName;

		u.setBalance(0);
		while (service.addUser(u) == null) {
			System.out.println("Username is taken. Please try another: ");
			uName = scan.nextLine();
			u.setUsername(uName);
		}
		service.addUser(u);
		System.out.println("Account successfully created.\n");
	}

	static void viewBalance(User u) {
		DecimalFormat df = new DecimalFormat(".##");

		System.out.println("Current Funds: " + "$" + df.format(u.getBalance()) + "\n");
	}

	static void depositFunds(User u, Scanner scan) { 
		DecimalFormat df = new DecimalFormat(".##");
		double depAmt;

		System.out.println("Enter the deposit amount: ");
		String strDepAmt = scan.nextLine();

		try {
			depAmt = Double.parseDouble(strDepAmt);
			if (depAmt <= 0) {
				System.out.println("Invalid amount***\n");
				depositFunds(u, scan);
			}
			System.out.println("Deposit " + df.format(depAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = u.getBalance();
					u.setBalance(currBal + depAmt);
					service.updateUser(u);
					goodInput = true;
					if (u.getBalance() == (currBal + depAmt))
						System.out.println("Funds successfully deposited.\n");
					else 
						System.out.println("We a apologize but there's been an error depositing your funds.\n");
					printMenu(u);
					break;
				case "no":
					System.out.println("Funds not deposited. Returning to Main Menu.\n");
					goodInput = true;
				default:
					System.out.println("Please enter yes or no.");
				}
			} while (goodInput == false);

		} catch (NumberFormatException e) {
			System.out.println("Invalid entry***\n");
			depositFunds(u, scan);
		}
	}

	static void withdrawFunds(User u, Scanner scan) {
		DecimalFormat df = new DecimalFormat(".##");
		double wdrwAmt;

		System.out.println("Enter the withdrawal amount: ");
		String strWdrwAmt = scan.nextLine();

		try {
			wdrwAmt = Double.parseDouble(strWdrwAmt);
			if (wdrwAmt <= 0) {
				System.out.println("Invalid amount***\n");
				withdrawFunds(u, scan);
			} else if (wdrwAmt > u.getBalance()) {
				System.out.println("There are not enough funds in your account for this operation***\n");
				withdrawFunds(u, scan);
			}
			System.out.println("Withdraw " + df.format(wdrwAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = u.getBalance();
					u.setBalance(currBal - wdrwAmt);
					service.updateUser(u);
					goodInput = true;
					if (u.getBalance() == (currBal - wdrwAmt))
						System.out.println(wdrwAmt + " withdrawn.\n");
					else 
						System.out.println("We a apologize but there's been an error withdrawing your funds.\n");
					printMenu(u);
					break;
				case "no":
					System.out.println("Funds not withdrawn. Returning to Main Menu.\n");
					goodInput = true;
				default:
					System.out.println("Please enter yes or no.");
				}
			} while (goodInput == false);

		} catch (NumberFormatException e) {
			System.out.println("Invalid entry***\n");
			withdrawFunds(u, scan);
		}
	}
}
