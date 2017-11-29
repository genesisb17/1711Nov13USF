package bank.ex.main;


import java.util.Scanner;

import bank.ex.dao.DAO;
import bank.ex.dao.DAOImp;
import bank.ex.pojos.*;

public class BankUserInterface {
	/* This is the main class of the banking system application. 
	 * This would be the user interface and where user interaction takes place.
	 * 
	 */
		static DAO dao = new DAOImp();
		static Scanner keyboard = new Scanner(System.in); 
		
	public static void main(String[] args) {

		run();
	}

	static void run() {
		/*This run method is a method that runs the banking system application.
		 * This method asks user for two possible entries, 1 to log it or 2 
		 * to create a user with the bank.
		 */
		User usr = new User();
		System.out.println("Welcome to Banking with Felix!\n With us, you're able to have up to 2 accounts per user!\n To log in, enter (1). To create a user, enter (2). \n");
		String input = keyboard.nextLine();
		switch(input) {
		case "1":
			usr = login();
			if(usr.getUserName().equals("NA")) {
				break;
			}
			else {
			homeScreen(usr);}
			break;
		case "2":
			usr = createUser();
			run();
			break;
		default:
			break;
		}
		run();
	}
	static User login() {
		/*This method is called to initiate the log in process. in this method
		 * is where the user will input log in credentials. 
		 * 
		 */
		User usr = new User();
		System.out.println("Enter your username: ");
		usr.setUserName(keyboard.nextLine().toLowerCase());
		System.out.println("Enter your password: ");
		usr.setPassWord(keyboard.nextLine());
		usr = dao.login(usr);
		return usr;
	}
	static void homeScreen(User client) {
		/*The homescreen method is where the user will be directed once having
		 * successfully logged in to their account. Here the user is offered 6 possible
		 * entries.
		 * 
		 * 1. Enter (1) to create a new account under the user. 
		 * 		*User is only limited to creating 2 accounts*
		 * 2. Enter (2) to view the balance on all of the accounts under the user.
		 * 3. Enter (3) to deposit money to account. User is then prompted to entering 
		 * 	  the exact ID of the account for which they would like to make a deposit into. 
		 * 4. Enter (4) to withdraw money from account. User is then prompted to entering
		 *    the exact ID of the account for which they would like to make a withdrawal from. 
		 *    	*User is not allowed to withdraw more money than present on any given account*
		 * 5. Enter (5) to update User profile. 
		 * 		* User is only limited to updating the Firstname or Lastname of user. *
		 * 6. Enter  (6) to log out. User is then returned to the run method, where they are
		 * 	  then prompted to log in or create account. 
		 *   
		 */
		int existFlag,acc_id;
		double deposit, withdraw, currentBalance, newBalance;
		System.out.println(client.getU_id());
		System.out.println("Welcome " + client.getFirstName() + " " + client.getLastName() + "!\n" + "To create an account under " + client.getUserName() + " enter (1).");
		System.out.println("To view the balance on your accounts, enter (2).");
		System.out.println("To deposit money into your account, enter (3).");
		System.out.println("To withdraw money from your account, enter (4).");
		System.out.println("To update your user profile, enter (5). \n \t Please be aware you can only update First and Last name on account.");
		System.out.println("To log out, enter (6).");
		String input;
		input = keyboard.nextLine();
		switch(input) {
		case "1":
			int accountTotal = dao.accountAmount(client);
			double initialDeposit;
			if(accountTotal == 2) {
				System.out.println("You've reached the maximum number of accounts permitted under Banking with Felix. \n Try a different Entry.");
				break;
			}
			System.out.println("How much would you like to deposit on your new account?");
			initialDeposit = keyboard.nextDouble();
			dao.addAccount(client, initialDeposit);
			break;
		case "2":
			accountTotal = dao.accountAmount(client);
			if(accountTotal ==0) {
				System.out.println("You havent created an account for yourself. Press 1 at the homescreen to create an account.");
			}
			else {
			dao.viewAccounts(client);}
			break;
		case "3":
			dao.viewAccounts(client);
			System.out.println("Please enter the account number for which you are looking to make a deposit for.");
			acc_id = keyboard.nextInt();
			existFlag = dao.existingAccount(acc_id);
			if(existFlag == 0) {
				System.out.println("Account ID does not exist. Please try again.");
				break;
			}
			currentBalance = dao.accountBalance(acc_id);
			System.out.println("How much would you like to deposit?");
			deposit = keyboard.nextDouble();
			if(deposit<0) {
				System.out.println("You cannot deposit a negative amount. You are now being redirected your homescreen.");
				break;
			}
		// place if statement to check if input is negative. if so, try again.
			newBalance = deposit + currentBalance;
			dao.updateAccountBalance(newBalance, acc_id);
			dao.viewAccounts(client);
			break;
		case "4":
			dao.viewAccounts(client);
			System.out.println("Please enter the account number for which you are looking to make a withdrawal from.");
			acc_id = keyboard.nextInt();
			existFlag = dao.existingAccount(acc_id);
			if(existFlag == 0) {
				System.out.println("Account ID does not exist. Please try again.");
				break;
			}
			currentBalance = dao.accountBalance(acc_id);
			System.out.println("How much would you like to withdraw?");
			withdraw = keyboard.nextDouble();
			if(withdraw > currentBalance) {
				System.out.println("You cannot withdraw more than what you have available on your account. Please try again.");
				break;
			}
			if(withdraw<0) {
				System.out.println("You cannot deposit a negative amount. You are now being redirected your homescreen.");
				break;
			}
			newBalance = currentBalance - withdraw;
			dao.updateAccountBalance(newBalance, acc_id);
			dao.viewAccounts(client);
			break;
		case "5":
			System.out.println("Enter (1) to update First Name or (2) to update Last Name");
			String homeScreenInput;
			homeScreenInput = keyboard.nextLine();
			switch(homeScreenInput) {
			case "1":
				System.out.println("Enter new First Name.");
				client.setFirstName(keyboard.nextLine());
				dao.updateUser(client);
				dao.viewAccounts(client);
				break;
			case "2":
				System.out.println("Enter new Last Name.");
				client.setLastName(keyboard.nextLine());
				dao.updateUser(client);
				break;
			default:
				break;
			}
			break;
		case "6":
			System.out.println("Thank you for Banking with Felix! We look forward to serving you again.");
			run();
			break;
		default:
			break;
		}
		homeScreen(client);
	}
	static User createUser() {
		/* This method is called when user selects (2) to create a new acocunt.
		 * they are asked to input information that will be needed to create their account.
		 * 
		 */
		User usr = new User();
		User returnUsr = new User();
		System.out.println("Welcome to the portal to create a new user!");
		System.out.println("Enter you first name.");
		usr.setFirstName(keyboard.nextLine());
		System.out.println("Enter your last name. ");
		usr.setLastName(keyboard.nextLine());
		System.out.println("Enter your desired username. ");
		usr.setUserName(keyboard.nextLine().toLowerCase());
		System.out.println("Enter your desired password. ");
		usr.setPassWord(keyboard.nextLine());
		returnUsr = dao.addUser(usr);
		System.out.println("Creating User. Return here.");
		return returnUsr;
	}
	
	
	
}
