package com.rev.main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

import com.rev.main.interfaces.BankOperations;
import com.rev.pojos.User;
import com.rev.service.Service;

public class BankOps implements BankOperations{

	private Scanner scan;
	private static BankOps bankOpsObject = null;
	private BankOpsValidator validator;
	private Service service;
	private HashMap<Integer, Supplier<User>> userOps;
	private HashMap<Integer, Runnable> bankOps;
	private User currentUser;
	
	private BankOps(Scanner s){
		this.scan = s;
		this.validator = BankOpsValidator.getInstance();
		this.service = new Service();
		this.userOps = this.initializeUserOps(userOps);
		this.bankOps = this.initializeBankOps(bankOps);
	}
	
	public static BankOps getInstance(Scanner s){
		if(bankOpsObject == null){
			bankOpsObject = new BankOps(s);
			return bankOpsObject;
		}else{
			return bankOpsObject;
		}
	}
	
	public HashMap<Integer, Supplier<User>> initializeUserOps(HashMap<Integer, Supplier<User>> ops){
		ops = new HashMap<Integer, Supplier<User>>();
		ops.put(1, () -> this.login());
		ops.put(2, () -> this.createAccount());
		return ops;
	}
	
	public HashMap<Integer, Runnable> initializeBankOps(HashMap<Integer, Runnable> ops){
		ops = new HashMap<Integer, Runnable>();
		ops.put(1, () -> this.makeDeposit());
		ops.put(2, () -> this.makeWithdrawal());
		ops.put(3, () -> this.checkBalance());
		return ops;
	}
	
	public int runOptions(String ...options){
		int op = 0;
		boolean operation = false;
		do{
			try{
				System.out.println();
				System.out.println("Please select one option (Enter choice number): ");
				for(int i = 0; i < options.length; i++) System.out.println((i+1) + ". " + options[i]);
				op = scan.nextInt();
				scan.nextLine();
				operation = true;
			}catch(InputMismatchException e){
				System.out.println("Please enter a valid choice number.");
				scan.nextLine();
				operation = false;
			}
		}while(!operation);
		return op;
	}
	
	@Override
	public void run() {
		System.out.println();
		System.out.println("Welcome to the Bank App!");
		System.out.println("--------------------------------------------------");
		int op = runOptions("Login", "Create Account");
		switch(op){
		     case 1: System.out.println("You've chosen to Login!"); 
		     		 currentUser = userOps.get(op).get();
		     		 System.out.println(); 
		     		 System.out.println("Hello " + currentUser.getFname() + "!"); 
		     		 runBankOps();
		             break;
			 case 2: System.out.println("You've chosen to create a new account!"); 
			 		 try{
			 			service.addUser(userOps.get(op).get());
			 		 }catch(NullPointerException e){
			 			service.addUser(userOps.get(op).get());
			 		 }
					 int next = continueOrExit();
					 if(next == 1) exit();
					 else if(next == 2) run();
					 break;
			default: run();
					 break;
		}
	}
	
	public void runBankOps(){
		int op = runOptions("Deposit", "Withdrawal", "Check Balance");
		switch(op){
		     case 1: System.out.println("You've chosen to make a deposit!"); 
		     		 bankOps.get(op).run();
		             break;
			 case 2: System.out.println("You've chosen to withdraw cash!"); 
			 		 bankOps.get(op).run();
					 break;
			 case 3: System.out.println("You've chosen to check your balance!"); 
			 		 bankOps.get(op).run();
					 break;
			default: run();
					 break;
		}
	}
	
	public boolean authorize(String pw1, String pw2){
		if(pw1.equals(pw2)) return true;
		else return false;
	}
	
	@Override
	public User login() {
		String username, password;
		boolean userFound = false, userAuth = false;
		User user;
		do{ 
			System.out.println("Please enter your username: ");
			username = scan.nextLine();
			user = service.getUser(username);
			if(user == null){
				System.out.println("No User found. Please try again...");
			}else{userFound = true;}
		}while(userFound == false);
		do{ 
			System.out.println("Please enter your password: ");
			password = scan.nextLine();
			if(!authorize(user.getPassword(), password)){
				System.out.println("Authorization failed. Please try again...");
			}else{userAuth = true;}
		}while(userAuth == false);
		return user;
	}

	@Override
	public User createAccount() {
		String fname, lname, username, password;
		boolean firstName = false, lastName = false, userName = false, passWord = false, next = false;
		int nextOption = 0;
		do{
			System.out.println("Please enter your first name: ");
			fname = scan.nextLine();
			if(validator.isFirstNameValid(fname)) firstName = true;
			else System.out.println("Sorry this name is invalid please try again...");
		}while(!firstName);
		do{
			System.out.println("Please enter your last name: ");
			lname = scan.nextLine();
			if(validator.isLastNameValid(lname)) lastName = true;
			else System.out.println("Sorry this name is invalid please try again...");
		}while(!lastName);
		do{
			System.out.println("Please enter a username: ");
			username = scan.nextLine();
			Object validation = validator.isUsernameValid(username);
			if(!(validation instanceof String) && ((Boolean)validation) == true) userName = true;
			else System.out.println(validation.toString());
		}while(!userName);
		do{
			System.out.println("Please enter a password: ");
			password = scan.nextLine();
			if(validator.isPasswordValid(password)) passWord = true;
			else System.out.println("Sorry this password is invalid please try again...");
		}while(!passWord);
		do{
			try{
				System.out.println("Please verify your information (Enter 1 to Continue or 2 to Re-Do): ");
				System.out.println("First Name: " + fname);
				System.out.println("Last Name: " + lname);
				System.out.println("Username: " + username);
				nextOption = scan.nextInt();
				scan.nextLine();
				next = true;
				if(nextOption == 2) return null;
				else return new User(fname, lname, username, password);
			}catch(InputMismatchException e){
				System.out.println("Please enter a valid choice number.");
				scan.nextLine();
				next = false;
			}
		}while(!next);
	 return null;
	}

	@Override
	public void makeDeposit() {
		double amount = 0;
		boolean amountOK = false;
		do{
			System.out.println("Please enter an amount: ");
			try{
				amount = Double.parseDouble(scan.nextLine());
				amountOK = true; 
			}catch(NumberFormatException e){
				amountOK = false;
				System.out.println("Sorry this is an invalid amount...");
			}
		}while(amountOK == false);
	    currentUser = service.deposit(currentUser, amount);
	    System.out.println("Deposit successful: ");
	    System.out.println("Your new balance is: " + currentUser.getBalance());
		sleep(1000);
	    int next = continueOrExit();
	    if(next == 1) exit();
	    else if(next == 2) runBankOps();
	}

	@Override
	public void makeWithdrawal() {
		double amount = 0;
		boolean amountOK = false;
		do{
			System.out.println("Please enter an amount (Current Balance is " + currentUser.getBalance() + ": ");
			try{
				amount = Double.parseDouble(scan.nextLine());
				if(amount > currentUser.getBalance()){
					System.out.println("Sorry this amount is more than your current balance..."); 
					amountOK = false;
				}else amountOK = true; 
			}catch(NumberFormatException e){
				amountOK = false;
				System.out.println("Sorry this is an invalid amount...");
			}
		}while(amountOK == false);
	    currentUser = service.withdraw(currentUser, amount);
	    System.out.println("Withdrawal successful: ");
	    System.out.println("Your new balance is: " + currentUser.getBalance());
		sleep(1000);
	    int next = continueOrExit();
	    if(next == 1) exit();
	    else if(next == 2) runBankOps();
	}

	public void checkBalance() {
		System.out.println("Your current balance is: " + currentUser.getBalance());
		sleep(1000);
	    int next = continueOrExit();
	    if(next == 1) exit();
	    else if(next == 2) runBankOps();
	}
	
	public int continueOrExit(){
		return runOptions("Exit", "Continue");
	}
	
	public void exit(){
		System.out.println();
		System.out.println("Logging out... ");
		currentUser = null;
		sleep(1000);
		System.out.println("Thanks for using BankApp! Come back soon.");
	}
	
	public void sleep(long l){
		try{Thread.sleep(l);} 
		catch (InterruptedException e){e.printStackTrace();}
	}
}
