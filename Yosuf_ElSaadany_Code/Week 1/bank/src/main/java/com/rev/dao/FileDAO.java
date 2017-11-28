package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

import com.rev.pojos.User;

public class FileDAO implements DAO{
	
	String filename = "src/main/resources/bank.txt";
	
	// For creating accounts
	public User addUser(User u) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true))){
			// Set id based on number of users in the file.
			
			int NumUsers = getAllUsers().size() + 1;
			u.setId(NumUsers);
			bw.write(u.toFile());
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// For making sure the account doesn't already exist 
	public User getUserByUsernameToCreateAccount(String username) {
		String[] about = null;
		String line = null;
		User temp = new User();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){ 
			while((line = br.readLine()) != null) {
				about = line.split(":");
				temp.setUsername(about[3]);
				if(temp.getUsername().equals(username)) {
					// Username is not available, user has to choose a different username
					return null;
				}
			}
			// After Searching through the file, the username is available
			System.out.println("Account successfully created");
			return temp;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return temp;
	}
	
	// For making sure the username exists in order to login
	public User getUserByUsernameToLogin(String username) {
		String[] about = null;
		String line = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){ 
			while((line = br.readLine()) != null) {
				about = line.split(":");
				User temp = new User();
				temp.setUsername(about[3]);
				if(temp.getUsername().equals(username)) {
					temp.setFirstname(about[1]);
					temp.setLastname(about[2]);
					temp.setUsername(about[3]);
					temp.setPassword(about[4]);
					temp.setBalance(Double.parseDouble(about[5]));
					return temp;
				}
			}
			System.out.println("Username is Invalid!");
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	// For making sure the password entered belongs to the username entered
	public User getUserByPasswordToLogin(String password, String username) {
		// TODO Auto-generated method stub
		String[] about = null;
		String line = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){ 
			while((line = br.readLine()) != null) {
				about = line.split(":");				
				User temp = new User();
				temp.setUsername(about[3]);
				if(temp.getUsername().equals(username)) {
					temp.setPassword(about[4]);
					if(temp.getPassword().equals(password)) {
						return temp;
					}
					else 
						return null;
				}
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Retrieving all the users from the database(text file)
	public ArrayList<User> getAllUsers() {
		ArrayList<User> Users = new ArrayList<User>();
		String[] about = null;
		String line = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){ 
			while((line = br.readLine()) != null) {
				about = line.split(":");				
				User temp = new User();
				temp.setId(Integer.parseInt(about[0]));
				temp.setFirstname(about[1]);
				temp.setLastname(about[2]);
				temp.setUsername(about[3]);
				temp.setPassword(about[4]);
				temp.setBalance(Double.parseDouble(about[5]));
				Users.add(temp);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return Users;
	}
	
	// Withdraw/Deposit by
	public User transaction(User u) {
		ArrayList<User> users = new ArrayList<User>();
		users = getAllUsers();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,false))){
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getUsername().equals(u.getUsername()))
					users.set(i, u);
				bw.write(users.get(i).toFile());
			}
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}