package run;

import java.util.List;

import dao.DAO;
import dao.DAOImplementation;
import pojos.Account;
import pojos.User;
import services.ConsoleHandler;

public class RunBank implements Runnable {

	private ConsoleHandler con;
	private DAO dao;

	public RunBank() {
		con = new ConsoleHandler();
		dao = new DAOImplementation();
	}

	public void run() {
		while (true) { // loop the bank app forever
			boolean repeat;
			System.out.println("Welcome to the bank!");
			do { // repeat getting input until its a valid selection
				repeat = false;
				int response = con.promptInt("Please make a selection:\n" + "Login          - 1\n" + "Create Account - 2");
				switch (response) {
				case 1:
					login();
					break;
				case 2:
					createUser();
					break;
				default:
					System.out.println("I'm sorry, that is not a valid selection.");
					repeat = true;
					break;
				}
			} while (repeat);
		}
	}

	private void createUser() {
		String email, password, fname, lname;
		while (dao.hasUser(email = con.promptString("Please enter your email:"))) { // repeat until they enter an unused email
			System.out.println("That email is already taken.");
		}
		while (!(password = con.promptString("Please enter your password:")).equals(con.promptString("Please confirm your password:"))) {
			System.out.println("Your passwords did not match"); //as long as passwords don't match
		}
		fname = con.promptString("Please enter your first name:");
		lname = con.promptString("Please enter your last name:");
		chooseAccount(dao.addUser(email, password, fname, lname));
	}

	private void login() {
		String email;
		while (!dao.hasUser(email = con.promptString("Please enter your username/email:"))) { // repeat until they input an existing email
			System.out.println("That did not match a valid usernam/email.");
		}
		User u = dao.getUser(email);
		while (!con.promptString("Please enter your password:").equals(u.getPassword())) { // repeat until they enter the correct password
			System.out.println("Your password did not match.");
		}
		chooseAccount(u);
	}

	private void chooseAccount(User u) {
		while (true) { //loop this until they choose to exit
			List<Account> accounts = dao.getAccounts(u);
			int numAccounts = accounts.size();
			int choice;
			System.out.println(String.format("Welcome %s %s.", u.getFname(), u.getLname()));
			if (accounts.isEmpty()) System.out.println("You do not currently have any accounts.");
			else {
				System.out.println("Please select an account:");
				for (int i = 0; i < numAccounts; i++) System.out.printf("%-12d%5s%n", accounts.get(i).getId(), "-" + (i + 1));
			}
			System.out.printf("Create Account%3s%n", "-" + (numAccounts + 1));
			System.out.printf("Log Out%10s%n", "-" + (numAccounts + 2));
			while (true) {
				choice = con.getInt();
				if (choice > 0 && choice <= numAccounts + 2) break;
				System.out.println("That is not a valid selection.  Please choose again:");
			}
			if (choice <= numAccounts) accountOptions(accounts.get(choice - 1));
			else if (choice == numAccounts + 1) accountOptions(dao.addAccount(u));
			else if (choice == numAccounts + 2) break;
		}
	}

	private void accountOptions(Account a) {
		boolean repeat = true;
		while(repeat) {
			System.out.printf("Account number %d%nMake a selection:%nView balance      -1%n" + 
					"Make a deposit    -2%nMake a withdrawal -3%nAdd a user        -4%nBack              -5%n", a.getId());
			switch(con.getInt()) {
			case 1:
				showBalance(a);
				break;
			case 2:
				a = deposit(a);
				break;
			case 3:
				a = withdraw(a);
				break;
			case 4:
				addUserToAccount(a);
				break;
			case 5:
				repeat = false;
				break;
			default:
				System.out.println("That is not a valid selection.");
				break;
			}
		}
	}
	
	private void addUserToAccount(Account a) {
		String email;
		while(!dao.hasUser(email = con.promptString("Please enter the email that you would like to add to this account:"))) {
			System.out.println("That is not the email address of a registered user.");
		}
		dao.addUserToAccount(a, dao.getUser(email));
	}

	private Account deposit(Account a) {
		double deposit;
		while((deposit = con.promptDouble("How much would you like to deposit?")) < 0.0f) {
			System.out.println("You cannot deposit a negative amount.");
		}
		a = dao.depositToAccount(a, deposit);
		showBalance(a);
		return a;
	}
	
	private Account withdraw(Account a) {
		double withdrawal;
		while(true) {
			showBalance(a);
			withdrawal = con.promptDouble("How much would you like to withdraw?");
			if(withdrawal <= 0.0f) System.out.println("You cannot withdraw a negative amount.");
			else if (withdrawal > a.getBalance()) System.out.println("That is more than your current balance.");
			else break;
		}
		a = dao.depositToAccount(a, -withdrawal);
		showBalance(a);
		return a;
	}
	
	private void showBalance(Account a) {
		System.out.printf("Current balance: $%.2f%n", a.getBalance());
	}

	public static void main(String[] args) {
		new RunBank().run();
	}

}
