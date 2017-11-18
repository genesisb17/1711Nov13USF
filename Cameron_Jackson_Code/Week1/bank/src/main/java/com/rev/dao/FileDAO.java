package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";
	public User addUser(User u) {
		try(BufferedWriter bw = new BufferedWriter(new  FileWriter(filename, true))) {
			// Should not be able to add users with a username that already exists
			// Add logic to validate inside of service AKA business layer
			bw.write(u.toFile());
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Search ArrayList of users for the requested username and 
	 * return the user object if found. otherwise return null
	 */
	public User getUser(String username) {
		ArrayList<User> users = userList();
		for (User u : users) 
			if (u.getUsername().equals(username)) return u;
		
		return null;
	}
	
	/*
	 * Return the current number of users
	 * used for setting correct user ID
	 */
	public int numUsers() {
		return userList().size();		
	}

	/*
	 * Read each user into ArrayList of users
	 */
	public ArrayList<User> userList() {
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		String line;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(":");
				user = new User(
						Integer.parseInt(userInfo[0]), // user ID
						userInfo[1], // first name
						userInfo[2], // last name
						userInfo[3], // username
						userInfo[4], // password
						Double.parseDouble(userInfo[5]) // deposit amount
						);
				users.add(user);
			} // END WHILE
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
}
