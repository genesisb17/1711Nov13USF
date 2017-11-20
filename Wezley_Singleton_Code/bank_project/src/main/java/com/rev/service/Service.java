package com.rev.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.exceptions.UserNameInUseException;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();
	
	public User addUser(User u) throws UserNameInUseException {
		
		// validate that username does not exist already
		System.out.println("\nChecking to see if " + u.getUserName() + " is in use...");
		
		for(User user : getAllUsers()) {
		
			if(u.getUserName().equals(user.getUserName())) {
				UserNameInUseException uniue = new UserNameInUseException();
				throw uniue;
			}
		}
		
		// if username is available
		System.out.println("Username, " + u.getUserName() + " is available!");
		dao.addUser(u);
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
	
}
