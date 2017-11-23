package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.rev.pojos.User;

public class FileDAO implements DAO{
	
	private String filename = "src/main/resources/bank.txt";
	private ArrayList<User> usersList;
	
	public FileDAO() {
		usersList = new ArrayList<User> ();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(":");
				if (userInfo.length < 5)
					break;
				User u = new User();
				u.setFirstname(userInfo[0]);
				u.setLastname(userInfo[1]);
				u.setUsername(userInfo[2]);
				u.setPassword(userInfo[3]);
				u.setBalance(new BigDecimal(userInfo[4]));
				
				usersList.add(u);
			}
		} catch (FileNotFoundException e) {
			// Don't do anything
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User addUser(User u) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){
			//should not be able to add users with a username that already exists
			// add logic to validate inside of service AKA business layer
			usersList.add(u);
			for (User user : usersList) {
				bw.write(user.toFile());
				bw.write("\n");
			}
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username) {
		for (User user : usersList) {
			if (user.getUsername().equalsIgnoreCase(username))
				return user;
		}
		
		return null;
	}
	
	public User updateUser(User u) {
		for(User user : usersList) {
			if (user.getUsername().equals(u.getUsername())) {
				user.setBalance(u.getBalance());
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){
					for (User us : usersList) {
						bw.write(us.toFile());
						bw.write("\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return u;
			}
		}
		return null;
	}

}
