package com.rev.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojos.User;

public class FileDAO implements DAO {
	
	String filename="src/main/resources/bank.txt";
	public User addUser(User u) {
		
		//try-with-resources
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true))){
			//should not be able to add users witha username that already exists
			//add logic to validate inside of service AKA business layer
			//have to read in entire text file
			bw.write(u.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username) {
		return null;
		
	}

}
