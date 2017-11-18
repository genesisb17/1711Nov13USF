package com.rev.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";
	
	public User addUser(User u) {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			
			// should not be able to add users with a username that already exists
			// add logic to validate inside service layer
			
			// writes the result of the given User object's toFile() method to the BufferedWriter object 
			bw.write(u.toFile());
			return u;
			
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}

	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
