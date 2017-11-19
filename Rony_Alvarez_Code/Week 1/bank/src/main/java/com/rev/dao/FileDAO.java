package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			// should not be able to add users with a username that already exists
			// add logic to validate inside of service AKA business layer
			bw.write(u.toFile());
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username, String password) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			
			while ((line = br.readLine()) != null) {

				String[] lineData = line.split(":");
				String[] temp = {lineData[3], lineData[4], lineData[5]};

				String tempUser = temp[0];
				String tempPass = temp[1];
				
				if(tempUser.equals(username) && tempPass.equals(password)) {
					
					double balance = Double.parseDouble(temp[2]);
					
					System.out.println("Welcome " + username + "! Your current balance is: " + balance);
					
					break;
					
				} else {
					
					System.out.println("We couldn't find your username :( Are your sure the information is correct?");
				
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return null;
	}

	@Override
	public User addMoney(double amount) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			while ((line = br.readLine()) != null) {

				String[] about = line.split(":");
				User temp = new User();
				temp.setUsername(about[2]);
				temp.setBalance(Double.parseDouble(about[6]));
				
				
//				temp.setName(about[0]);
//				temp.setAge(Integer.parseInt(about[1]));
				
//				if() {
//					
//				}
				
				//temp.setBalance(balance);
				about[6] = about[6] + amount;

				//users.add(about[5]);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;
	}

	@Override
	public User getBalance(String username, String password) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			
			while ((line = br.readLine()) != null) {

				String[] lineData = line.split(":");
				String[] temp = {lineData[3], lineData[4], lineData[5]};

				String tempUser = temp[0];
				String tempPass = temp[1];
				
				if(tempUser.equals(username) && tempPass.equals(password)) {
					
					double balance = Double.parseDouble(temp[2]);
					
					System.out.println("Your current balance is: " + balance);
					
					break;
					
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return null;
		
	}

}
