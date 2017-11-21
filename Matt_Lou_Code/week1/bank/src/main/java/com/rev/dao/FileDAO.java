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
		// the try block auto closes the file, true parameter means appending file
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			// should not be able to add users with a username that already exists
			// add logic to validate inside of service via aka business layer
			bw.write(u.toFile());
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}

	public User getUser(String username) {
		return null;
	}
	
	public User update(User u) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String str = "";
			ArrayList<String[]> strArr = new ArrayList<String[]>();
			
			while((str = br.readLine()) != null) {
				strArr.add(str.split(":"));
			}
			System.out.println(strArr.size());
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));
			for(int i = 0; i < strArr.size(); i++) {
				if(strArr.get(i)[3].equals(u.getUsername())) {
					String[] stringarr = {String.valueOf(u.getId()), u.getFirstname(), u.getLastname(), 
							u.getUsername(), u.getPassword(), String.valueOf(u.getBalance())};
					
					strArr.set(i, stringarr);
				}
			}	
			for(int i = 0; i < strArr.size(); i++)
			{
				for (int j = 0; j < 6 ; j++) {
					System.out.println(strArr.get(i)[j] + ":");
					bw.write(strArr.get(i)[j] + ":");
				}
			}
			return u;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
