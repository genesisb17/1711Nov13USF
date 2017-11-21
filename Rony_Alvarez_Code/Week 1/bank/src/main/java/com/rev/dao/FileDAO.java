package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
					
				} else if(!tempUser.equals(username) || !tempPass.equals(password))  {
					
									
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
	public User addMoney(String username, String password, String amount) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			
			while ((line = br.readLine()) != null) {

				String[] lineData = line.split(":");
				String[] temp = {lineData[3], lineData[4], lineData[5]};

				String tempUser = temp[0];
				String tempPass = temp[1];
				
				if(tempUser.equals(username) && tempPass.equals(password)) {
					
					double balance = Double.parseDouble(temp[2]);
					double newAmount = Double.parseDouble(amount);
					double finalBalance = balance + newAmount;
					
					String finalBalanceString = finalBalance + "";
					String balanceString = balance + "";
					
					modifyFile(filename, balanceString, finalBalanceString);
					
					System.out.println("The money has been added to your account. Thank you for being a loyal customer!");
					
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

	static void modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceFirst(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public User withdrawMoney(String username, String password, String amount) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line = null;
			
			while ((line = br.readLine()) != null) {

				String[] lineData = line.split(":");
				String[] temp = {lineData[3], lineData[4], lineData[5]};

				String tempUser = temp[0];
				String tempPass = temp[1];
				
				if(tempUser.equals(username) && tempPass.equals(password)) {
					
					double balance = Double.parseDouble(temp[2]);
					double newAmount = Double.parseDouble(amount);
					double finalBalance = balance - newAmount;
					
					String finalBalanceString = finalBalance + "";
					String balanceString = balance + "";
					
					modifyFile(filename, balanceString, finalBalanceString);
					
					System.out.println("The money has been removed from your account. Thank you for being a loyal customer!");
					
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
