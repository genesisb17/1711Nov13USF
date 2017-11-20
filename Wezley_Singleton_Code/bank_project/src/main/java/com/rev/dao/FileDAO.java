package com.rev.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;
import com.rev.service.Service;

public class FileDAO implements DAO {

	public static String filename = "src/main/resources/bank.txt";
	public static Service service = new Service();

	public User addUser(User u) {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {

			// writes the result of the given User object's toFile() method to the BufferedWriter object
			bw.write(u.toFile() + "\n");
			return u;

		} 

		catch (IOException e) {
			e.printStackTrace();
		}

		return null;



	}

	public User getUser(String username) {
		
		User soughtUser = new User();
		soughtUser.setUserName(username);

		for(User user : service.getAllUsers()) {

			if(user.getUserName().equals(soughtUser.getUserName())) {

				soughtUser.setId(user.getId());
				soughtUser.setFirstName(user.getFirstName());
				soughtUser.setLastName(user.getLastName());
				soughtUser.setUserName(user.getUserName());
				soughtUser.setPassword(user.getPassword());

				return soughtUser;

			}

		}

		System.out.println("\nNo user found! Returning to admin menu...");
		return null;

	}

	@Override
	public User updateUser(User updatedUser) {
		
		ArrayList<User> users = service.getAllUsers();
		
		System.out.println("Attempting to update user " + updatedUser.getId() + "...");
		
		for(User user : users) {
			
			if(updatedUser.getId() == user.getId()) {
				
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				user.setUserName(updatedUser.getUserName());
				user.setPassword(updatedUser.getPassword());
				user.setBalance(updatedUser.getBalance());
				
				service.updateFile(users);
				
				return user;
				
			}
			
		}
		
		return null;
	}

	@Override
	public User removeUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}


}
