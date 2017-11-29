package com.revature.run;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;
import com.revature.service.BankService;

public class RunBank {

	static BankService service = new BankService();
	
	public static void main(String[] args) {
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
			createAccount(scan);
		case "2": 
			System.out.println("Login");
			System.out.println("=====");
			currentUser = login(scan);
			System.out.println("Login successful.\n");
			mainMenu(currentUser, scan);
			break;
		default: run();
		}
		scan.close();
	}
	
	static void printMainMenu(User u) {
		System.out.println("The Bank");
		System.out.println("========");
		System.out.println("User " + (1+u.getUserId()) + ": " + u.getFirstname() + " " + u.getLastname());
		System.out.println("What would you like to do?");
		System.out.println("Setup a Bank Account(1)");
		System.out.println("View Balance(2)");
		System.out.println("Make Deposit(3)");
		System.out.println("Make Withdrawal(4)");
		System.out.println("Update Password(5)");
		System.out.println("Logout and Exit(6)");
	}

	static void mainMenu(User u, Scanner scan) {
		printMainMenu(u);

		String op;
		do {
			System.out.println("Please make a selection: ");
			op = scan.nextLine();
			switch (op) {
			case "1":
				// setup bank account function
				System.out.println("Setup Bank Account");
				System.out.println("==================");
				setupBankAccount(u, scan);
				break;
			case "2":
				// view balance function
				System.out.println("View Balance");
				System.out.println("============");
				viewBalance(u);
				break;
			case "3":
				// make deposit function
				System.out.println("Deposits");
				System.out.println("========");
				depositFunds(u, scan);
				break;
			case "4":
				// make withdrawal function
				System.out.println("Withdrawals");
				System.out.println("===========");
				withdrawFunds(u, scan);
				break;
			case "5":
				// update password
				System.out.println("Password Update");
				System.out.println("===============");
				updatePass(scan);
				break;
			case "6":
				// exit
				break;
			default:
				System.out.println("Not a valid option please enter another");
			} // END SWITCH
		} while (!op.equals("6")); // END WHILE
		System.out.println("Thank you for using The Bank. Have a nice day.");
	}

	static User getUserInfo(Scanner scan) {
		User u = new User();

		System.out.println("Enter your username: ");
		u.setUsername(scan.nextLine().toLowerCase());
		System.out.println("Enter your password: ");
		u.setPassword(scan.nextLine());

		return u;
	}
	
	static void createAccount(Scanner scan) { 
		User u = new User();
		
		System.out.println("Please enter your first name: ");
		u.setFirstname(scan.nextLine());
		System.out.println("Enter your last name: ");
		u.setLastname(scan.nextLine());
		System.out.println("Enter your desired username: ");
		u.setUsername(scan.nextLine().toLowerCase());
		System.out.println("Enter your desired password: ");
		u.setPassword(scan.nextLine());
		
		while (service.addUser(u) == null) {
			System.out.println("Username is taken. Please try another: ");
			u.setUsername(scan.nextLine().toLowerCase());
			System.out.println("Enter your desired password: ");
			u.setPassword(scan.nextLine());
		}
		
		System.out.println("Account successfully created.\n");
	}
	
	static User login(Scanner scan) {
		String username, password;
		
		System.out.println("Enter your username: ");
		username = scan.nextLine().toLowerCase();
		System.out.println("Enter your password: ");
		password = scan.nextLine();
		
		User cUser = service.login(username, password);
		if (cUser == null) {
			System.out.println("Incorrect username or password. Please try again.");
			cUser = login(scan);
		}
		return cUser; // object referring to current user
	}
	
	static void setupBankAccount(User u, Scanner scan) {
		Account acc = new Account();
		System.out.println("What type of account would you like to start?");
		System.out.println("Checking (1)");
		System.out.println("Savings  (2)");
		String s = scan.nextLine();
		
		// Set proper account type
		switch (s) {
		case "1":
			acc.setAccountType(AccountType.CHECKING);
			break;
		case "2":
			acc.setAccountType(AccountType.SAVINGS);
			break;
		default:
			System.out.println("Not a valid selection.");
			setupBankAccount(u, scan);
		}
		
		// Assign account to user
		acc.setUserId(u.getUserId());
		service.addAccount(acc);
		
		System.out.println("Your account number is: " + acc.getAccountId());
		System.out.println("Would you like to make an initial deposit?");
		System.out.println("Yes (1)\nNo  (2)");
		s = scan.nextLine();
		switch (s) {
		case "1":
			depositFunds(u, acc, scan);
			break;
		case "2":
			System.out.println("Account successfully created.");
			printMainMenu(u);
			break;
		default:
			System.out.println("No choice made. Returning to main menu.");
			printMainMenu(u);
		}
	}
	
	static void viewBalance(User u) {
		DecimalFormat df = new DecimalFormat(".##");
		
		ArrayList<Account> accounts = new ArrayList<>();
		accounts = service.getUserAccounts(u);
		
		if (accounts.size() > 0) {
			System.out.println("Current funds: ");
			for (Account acc : accounts) {
				System.out.println("Account (" + acc.getAccountId() + "): " + Account.accountTypeFromEnum(acc.getAccountType()));
				System.out.println("	Balance: $" + df.format(acc.getBalance()));
				System.out.println("");
			}
		} else {
			System.out.println("No bank accounts associated with this profile.");
			System.out.println("");
		}
		printMainMenu(u);
	}
	
	static void printAccountIds(User u, ArrayList<Account> accounts) {
		for (Account acc : accounts) {
			System.out.println(Account.accountTypeFromEnum(acc.getAccountType()) + 
					": (" + acc.getAccountId() + ")");
		}
	}

	static void depositFunds(User u, Account acc, Scanner scan) {
		DecimalFormat df = new DecimalFormat(".##");
		double depAmt;
		
		System.out.println("Current balance: $" + df.format(acc.getBalance()));
		try {
			do {
				System.out.println("Enter the deposit amount: ");
				String strDepAmt = scan.nextLine();
				depAmt = Double.parseDouble(strDepAmt);
				if (depAmt <= 0) {
					System.out.println("Invalid amount***\n");
				}
			} while (depAmt <= 0);
			System.out.println("Deposit " + df.format(depAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = acc.getBalance();
					double newbal = currBal + depAmt;
					Account updAcc = new Account();
					updAcc = service.updateBalance(newbal, acc.getAccountId());
					goodInput = true;
					if (updAcc.getBalance() == newbal)
						System.out.println("Funds successfully deposited.\n");
					else
						System.out.println("There was an error processing your deposit\n");
					printMainMenu(u);
					break;
				case "no":
					System.out.println("Funds not deposited. Returning to Main Menu.\n");
					goodInput = true;
					break;
				default:
					System.out.println("Please enter yes or no.");
				}
			} while (goodInput == false);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Entry");
			depositFunds(u, acc, scan);
		}
	}
	
	static boolean correctAccount(ArrayList<Account> accounts, int acc_id) {
		for (Account acc : accounts) {
			if (acc.getAccountId() == acc_id)
				return true;
		}
		return false;
	}
	
	static void depositFunds(User u, Scanner scan) { 
		DecimalFormat df = new DecimalFormat(".##");
		double depAmt;
		Account acc = new Account();
		
		try {
			ArrayList<Account> accounts = service.getUserAccounts(u);
			int acc_id;
			do {
				System.out.println("Select an account to make deposit: ");
				printAccountIds(u, accounts);

				String s = scan.nextLine();
				acc_id = Integer.parseInt(s);
			} while (!correctAccount(accounts, acc_id));
			acc = service.getAccount(acc_id);
		} catch (NumberFormatException e) {
			System.out.println("Invalid account selected.");
			depositFunds(u, scan);
		}
		System.out.println("Current balance: $" + df.format(acc.getBalance()));
		try {
			do {
				System.out.println("Enter the deposit amount: ");
				String strDepAmt = scan.nextLine();
				depAmt = Double.parseDouble(strDepAmt);
				if (depAmt <= 0) {
					System.out.println("Invalid amount***\n");
				}
			} while (depAmt <= 0);
			System.out.println("Deposit " + df.format(depAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = acc.getBalance();
					double newbal = currBal + depAmt;
					Account updAcc = new Account();
					updAcc = service.updateBalance(newbal, acc.getAccountId());
					goodInput = true;
					if (updAcc.getBalance() == newbal)
						System.out.println("Funds successfully deposited.\n");
					else
						System.out.println("There was an error processing your deposit\n");
					printMainMenu(u);
					break;
				case "no":
					System.out.println("Funds not deposited. Returning to Main Menu.\n");
					goodInput = true;
					break;
				default:
					System.out.println("Please enter yes or no.");
				}
			} while (goodInput == false);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Entry");
			depositFunds(u, acc, scan);
		}
	}
	
	static void withdrawFunds(User u, Scanner scan) {
		DecimalFormat df = new DecimalFormat(".##");
		double wdrwAmt;

		Account acc = new Account();
		
		try {
			ArrayList<Account> accounts = service.getUserAccounts(u);
			int acc_id;
			do {
				System.out.println("Select an account to make withdrawal: ");
				printAccountIds(u, accounts);

				String s = scan.nextLine();
				acc_id = Integer.parseInt(s);
			} while (!correctAccount(accounts, acc_id));
			acc = service.getAccount(acc_id);
		} catch (NumberFormatException e) {
			System.out.println("Invalid account selected.");
			withdrawFunds(u, scan);
		}
		System.out.println("Current balance: $" + df.format(acc.getBalance()));
		try {
			do {
				System.out.println("Enter the withdrawal amount: ");
				String strWdrwAmt = scan.nextLine();
				wdrwAmt = Double.parseDouble(strWdrwAmt);
				if (wdrwAmt <= 0) {
					System.out.println("Invalid amount***\n");
				} else if (wdrwAmt > acc.getBalance()) {
					System.out.println("There are not enough funds in your account for this operation***\n");
				}
			} while ((wdrwAmt <= 0) || (wdrwAmt > acc.getBalance()));
			System.out.println("Withdraw " + df.format(wdrwAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = acc.getBalance();
					double newbal = currBal - wdrwAmt;
					Account updAcc = new Account();
					updAcc = service.updateBalance(newbal, acc.getAccountId());
					goodInput = true;
					if (updAcc.getBalance() == newbal)
						System.out.println(wdrwAmt + " withdrawn.\n");
					else
						System.out.println("There was an error with your request\n");
					printMainMenu(u);
					break;
				case "no":
					System.out.println("Funds not withdrawn. Returning to Main Menu.\n");
					goodInput = true;
					break;
				default:
					System.out.println("Please enter yes or no.");
				} // END SWITCH
			} while (goodInput == false);

		} catch (NumberFormatException e) {
			System.out.println("Invalid entry***\n");
			withdrawFunds(u, acc, scan);
		}
	}

	static void withdrawFunds(User u, Account acc, Scanner scan) {
		DecimalFormat df = new DecimalFormat(".##");
		double wdrwAmt;
		System.out.println("Current balance: $" + df.format(acc.getBalance()));
		try {
			do {
				System.out.println("Enter the withdrawal amount: ");
				String strWdrwAmt = scan.nextLine();
				wdrwAmt = Double.parseDouble(strWdrwAmt);
				if (wdrwAmt <= 0) {
					System.out.println("Invalid amount***\n");
				} else if (wdrwAmt > acc.getBalance()) {
					System.out.println("There are not enough funds in your account for this operation***\n");
				}
			} while ((wdrwAmt <= 0) || (wdrwAmt > acc.getBalance()));
			System.out.println("Withdraw " + df.format(wdrwAmt) + "?");
			System.out.println("yes/no:");
			boolean goodInput = false;
			do {
				String op = scan.nextLine().toLowerCase();
				switch (op) {
				case "yes":
					double currBal = acc.getBalance();
					double newbal = currBal - wdrwAmt;
					Account updAcc = new Account();
					updAcc = service.updateBalance(newbal, acc.getAccountId());
					goodInput = true;
					if (updAcc.getBalance() == newbal)
						System.out.println(wdrwAmt + " withdrawn.\n");
					else
						System.out.println("There was an error with your request\n");
					printMainMenu(u);
					break;
				case "no":
					System.out.println("Funds not withdrawn. Returning to Main Menu.\n");
					goodInput = true;
					break;
				default:
					System.out.println("Please enter yes or no.");
				} // END SWITCH
			} while (goodInput == false);

		} catch (NumberFormatException e) {
			System.out.println("Invalid entry***\n");
			withdrawFunds(u, acc, scan);
		}
	}
	
	/*
	 * Doesn't take user object because that information will
	 * be reverified for security purposes
	 */
	static void updatePass(Scanner scan) {
		System.out.println("For security purposes please sign in again before updating password.");
		User u = login(scan);
		System.out.println("Enter new password: ");
		String newpass1 = scan.nextLine();
		System.out.println("Confirm new password: ");
		String newpass2 = scan.nextLine();
		
		while (!newpass1.equals(newpass2)) {
			System.out.println("New password and confirm password do not match.");
			System.out.println("Enter new password: ");
			newpass1 = scan.nextLine();
			System.out.println("Confirm new password: ");
			newpass2 = scan.nextLine();
		}
		
		service.updatePassword(newpass2, u.getUserId());
		printMainMenu(u);
	}
	
}
