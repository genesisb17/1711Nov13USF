package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;

public final class FileDao implements DAO {

	private String fileName = "src/main/resources/bank.txt";
	
	public User addUser(User u) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))){
			//should not be able to add users with a username that already exist
			bw.write(u.toFile());
			bw.write("\n");
			return u;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line=br.readLine())!=null) {
				String[] about = line.split(":");
				User user = new User();
				user.setUserName(about[3]);
				if (username.equals(user.getUserName())) {
					user.setId(Integer.parseInt(about[0]));
					user.setFirstName(about[1]);
					user.setLastName(about[2]);
					user.setPassword(about[4]);
					user.setBalance(Double.parseDouble(about[5]));
					return user;
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

	@Override
	public double getBalance(User u) {
		// TODO Auto-generated method stub
		System.out.println("Your balance is $" + u.getBalance());
		return u.getBalance();
	}

	@Override
	public double depositMoney(User currentUser, double amount) {
		ArrayList<User> users = new ArrayList<User>();
		int index = -1;
		//how many times was there an of the same object in the list. This should never be greater than 1.
		int indexHits = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line=br.readLine())!=null) {
				String[] about = line.split(":");
				User user = new User();
				user.setId(Integer.parseInt(about[0]));
				user.setFirstName(about[1]);
				user.setLastName(about[2]);
				user.setUserName(about[3]);
				user.setPassword(about[4]);
				user.setBalance(Double.parseDouble(about[5]));
				
				if(!user.toFile().equals(currentUser.toFile())) {
					//users.remove(user);
					users.add(user);
					//System.out.println("index");
				}
				else {
					//System.out.println("Found duplicate.");
					System.out.println("Acount updated");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentUser.setBalance(currentUser.getBalance() + amount);
		users.add(currentUser);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			//should not be able to add users with a username that already exist
			for (User u: users) {
				bw.write(u.toFile());
				bw.write("\n");
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	

}
