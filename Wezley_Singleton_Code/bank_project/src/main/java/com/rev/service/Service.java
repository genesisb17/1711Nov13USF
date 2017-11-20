package com.rev.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.exceptions.UserNameInUseException;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();
	
	public User addUser(User u) throws UserNameInUseException {
		
		// validate that username does not exist already
		System.out.println("\nChecking to see if " + u.getUserName() + " is in use...");
		checkUserNameAvailablility(u.getUserName());
		
		// if username is available
		System.out.println("Username, " + u.getUserName() + " is available!");
		dao.addUser(u);
		return u;
	}
	
	// retrieves user information about a given user (ADMIN use only)
	public User getUser(String username) {
		
		User u = dao.getUser(username);
		return u;
	
	}
	
	// updates a user, using an updated user object
	public User updateUser(User updatedUser) {
		
		User u = dao.updateUser(updatedUser);
		return u;
		
	}
	
	// returns an ArrayList containing all users from the data store
	public ArrayList<User> getAllUsers() {

		ArrayList<User> users = new ArrayList<User>();

		try (BufferedReader br = new BufferedReader(new FileReader(FileDAO.filename));) {
			String line = null;

			while ((line = br.readLine()) != null) {

				String[] about = line.split(":");
				User temp = new User();
				temp.setId(Integer.parseInt(about[0]));
				temp.setFirstName(about[1]);
				temp.setLastName(about[2]);
				temp.setUserName(about[3]);
				temp.setPassword(about[4]);
				temp.setBalance(Double.parseDouble(about[5]));
				users.add(temp);

			}

		}

		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return users;
		
	}
	
	public User createAccount(Scanner scan) {
		
		User u = new User();
		
		u.setId(determineIdNumForNewUser());
		
		System.out.print("Enter your first name: ");
		u.setFirstName(scan.nextLine());
		
		System.out.print("Enter your last name: ");
		u.setLastName(scan.nextLine());
		
		System.out.print("Enter your desired username: ");
		u.setUserName(scan.nextLine());
		
		System.out.print("Enter your desired password: ");
		u.setPassword(scan.nextLine());
		
		u.setBalance(0.0);
		
		// attempts to add user to text file, if the username given is already in use throws UserNameInUseException
		try {
			addUser(u);
		}
		
		catch (UserNameInUseException uniue) {
			createAccount(scan);
		}
		
		return u;
	}

	// prints all users from the data store to the console (ADMIN USE ONLY)
	public void printAllUsers() {
		
		for(User user : getAllUsers()) {
			System.out.println("Id: " + user.getId());
			System.out.println("First name: " + user.getFirstName());
			System.out.println("Last name: " + user.getLastName());
			System.out.println("Username: " + user.getUserName());
			System.out.println("Password: " + user.getPassword());
			System.out.println("+----------------------------------+");
		}
		
	}
	
	// prints a given user's details to the console
	public void printUserToConsole(User user) {
		
		if(user != null) {
			
			System.out.println("\nResult");
			System.out.println("+----------------------------------+");
			System.out.println("\tId: " + user.getId());
			System.out.println("\tFirst name: " + user.getFirstName());
			System.out.println("\tLast name: " + user.getLastName());
			System.out.println("\tUsername: " + user.getUserName());
			System.out.println("\tPassword: " + user.getPassword());
			System.out.println("\tBalance: " + user.getBalance());
			
		}
		
	}
	
	/*
	 *  determines the proper ID number for a new user, by iterating over the list and incrementing the last ID num
	 *  in the data store by one
	 */
	public int determineIdNumForNewUser() {
		int id = 0;
		
		for(User user : getAllUsers()) {
			id = user.getId();
		}
		
		return ++id;
	}
	
	
	// prints the given user's balance to the screen
	public void viewUserBalance(User u) {
		System.out.println("\nBalance: $" + u.getBalance() + "\n");
	}
	
	public StringBuilder convertFileToString() {
		
		StringBuilder fileString = new StringBuilder();
		
		ArrayList<User> users = getAllUsers();
		
		for(User user : users) {
			fileString.append(user.toFile() + "\n");
		}
		
		return fileString;
		
	}
	
	public void checkUserNameAvailablility(String username) throws UserNameInUseException {
		for(User user : getAllUsers()) {
			
			if(username.equals(user.getUserName())) {
				UserNameInUseException uniue = new UserNameInUseException();
				throw uniue;
			}
		}
	}
	
	public void updateFile(ArrayList<User> users) {
		
		System.out.println("Updating file...\n");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FileDAO.filename, false))) {

			for(User user : users) {
				bw.write(user.toFile() + "\n");
			}

		} 

		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void makeDeposit(Scanner scan, User u) throws NumberFormatException {
		
		String depositString = "";
		double currentBalance = u.getBalance();
		double depositAmount = 0.0;
		
		System.out.print("Please enter the amount you would like to deposit: ");
		depositString = scan.nextLine();
		
		try {
			depositAmount = Double.parseDouble(depositString);
		}
		
		catch(NumberFormatException nfe) {
			throw nfe;
		}
		
		u.setBalance(currentBalance + depositAmount);
		
		dao.updateUser(u);
		
	}
	
	public void makeWithdrawal(Scanner scan, User u) throws NumberFormatException {

		String withdrawalString = "";
		double withdrawalAmount = 0.0;
		double currentBalance = u.getBalance();
		
		System.out.print("Please enter the amount you would like to withdraw: ");
		withdrawalString = scan.nextLine();
		
		try {
			withdrawalAmount = Double.parseDouble(withdrawalString);
		}
		
		catch (NumberFormatException nfe) {
			throw nfe;
			
		}
		
		if(currentBalance - withdrawalAmount >= 0) {
			System.out.println("Withdrawing $" + withdrawalAmount + "...");
			dao.updateUser(u);
		}
		
		else {
			System.out.println("Insufficient funds in account. Withdrawal failed...");
			u.setBalance(currentBalance);
			dao.updateUser(u);
		}		
	}
}
