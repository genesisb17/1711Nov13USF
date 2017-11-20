package com.rev.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	
	static DAO dao = new FileDAO();
	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {
		// validate that username does not exist
		//assuming that it DNE:
		if(!isUser(u))
			dao.addUser(u);
		else
			System.out.println("Username already exists, please try again.");
		return u;
	}
	
	public User getUser(String uName) {
		return dao.getUser(uName);
	}
	
	public boolean isUser(User u) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = null;
			while((line = br.readLine()) != null) {
				String[] about = line.split(":");
				if(u.getuName().equals(about[3]))
					return true;
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	public void updateBalance(double oldValue, double newValue) {
		String oldContent = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = null;
			while((line = br.readLine()) != null) {
				oldContent = oldContent + line + System.lineSeparator();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		String newContent = oldContent.replaceAll(Double.toString(oldValue), Double.toString(newValue));
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
			bw.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
