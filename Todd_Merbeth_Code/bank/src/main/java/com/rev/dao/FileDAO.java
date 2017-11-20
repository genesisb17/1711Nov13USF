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

	/*
	 * Adds user info to the text file. User already existing is
	 * checked in service method
	 */
	public User addUser(User u) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			// should not be able to add users with a username that already exists
			// add logic to validate inside of service AKA business layer
			bw.write(u.toFile());
			// updateUsernames();
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * This updates user balance info within the file by rewriting all of the data from the passed array
	 * which will contain all users.
	 */
	public void updateUserData(ArrayList<User> users) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
			for(int i = 0; i<users.size(); i++) {
				bw.write(users.get(i).toFile());
			}
			// updateUsernames();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This reads the file and returns the arraylist with all usernames in the file
	 * It's meant to only have to be run once when the bank is first run and then 
	 * service can handle the rest.
	 */
	public ArrayList<User> updateUserList(ArrayList<User> names) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) { // Construct a new user for each line of data
				String[] data = line.split(":");
				User user = new User(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4],
						Double.parseDouble(data[5]));
				names.add(user); // Add the user to the list
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return names;  // Pass the array of users to the service for it to use so that we dont need 
					   // to access the file over and over
	}

}
