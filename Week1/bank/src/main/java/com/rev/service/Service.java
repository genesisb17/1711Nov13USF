package com.rev.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;


public class Service {

	static DAO dao = new FileDAO(); 
	static String fileName = "src/main/resources/bank.txt";
	
	public User updateBalance(User client, double withdraw) {
		
		StringBuffer inputBuffer = new StringBuffer(); //synchronized, more convenient to use
		try {	
		//User useR = .getUser(userName)
	//	System.out.println("Balance once having entered updateUser: " + client.getBalance()); //debugging purpose
	//	System.out.println("User name is: " + client.getUserName());
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String line;
		
		while((line = file.readLine()) != null){
			inputBuffer.append(line); //adds line read in from file to the buffer
			inputBuffer.append('\n'); //adds new line to buffer
		}
		
		// ****** StringBuffer inputStr = inputBuffer; // converts  everything read in from buffer to st
	//	System.out.println("Buffer is now : \n \n \n" + inputBuffer);
		file.close();
		
		if(true) {

			double updateBalance = client.getBalance() - withdraw; // make sure to add + deposit after debugging
			String add = client.getUserName() + ":" + client.getPassWord() + ":" + Double.toString(client.getBalance());//string to be replaced
			String newBalance = Double.toString(updateBalance);
			String replaceWith = client.getUserName() + ":" + client.getPassWord() + ":" + newBalance;
	//		System.out.println("String to be replaced: " + add); //debugging
	//		System.out.println("Double version of balance: " + updateBalance); //debugging
	//		System.out.println("User is: " + client.getUserName()+client.getPassWord());
			String newer = inputBuffer.toString();
			newer=newer.replace(add, replaceWith );
	//		System.out.println("Buffer to be written in file: \n " + newer);
			dao.updateMoney(client, newer);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;

	}
	public User updateUser(User client, double deposit) {
		StringBuffer inputBuffer = new StringBuffer(); //synchronized, more convenient to use
		try {	
		//User useR = .getUser(userName)
	//	System.out.println("Balance once having entered updateUser: " + client.getBalance()); //debugging purpose
	//	System.out.println("User name is: " + client.getUserName());
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String line;
		
		while((line = file.readLine()) != null){
			inputBuffer.append(line); //adds line read in from file to the buffer
			inputBuffer.append('\n'); //adds new line to buffer
		}
		
		// ****** StringBuffer inputStr = inputBuffer; // converts  everything read in from buffer to st
	//	System.out.println("Buffer is now : \n \n \n" + inputBuffer);
		file.close();
		
		if(true) {
			double updateBalance = client.getBalance() + deposit; // make sure to add + deposit after debugging
			String add = client.getUserName() + ":" + client.getPassWord() + ":" + Double.toString(client.getBalance());//string to be replaced
			String newBalance = Double.toString(updateBalance);
			String replaceWith = client.getUserName() + ":" + client.getPassWord() + ":" + newBalance;
	//		System.out.println("String to be replaced: " + add); //debugging
	//		System.out.println("Double version of balance: " + updateBalance); //debugging
	//		System.out.println("User is: " + client.getUserName()+client.getPassWord());
			String newer = inputBuffer.toString();
			newer=	newer.replace(add, replaceWith );
	//		System.out.println("Buffer to be written in file: \n " + newer);
			dao.updateMoney(client, newer);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}

	public User addUser(User person) {
		//validate that username does not exist
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			while((line = br.readLine())!= null) {
			String [] about = line.split(":");
		//	System.out.println("String size is: " + about.length);
			if(about.length == 1) {
				dao.addUser(person);
				System.out.println("You can now log in and check your account.\n");
				return person;
			}
			if (about[3].equals(person.getUserName())) {
				System.out.println("My guy, be yourself. That username is already taken, fill out the form again!\n\n");
				return person;
			}
		}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assuming that it does not exist:
		dao.addUser(person);
		System.out.println("You can now log in and check your account.\n");
		return person;
	}

	public User login(User person) {
		User useR = new User();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			useR.setUserName("null");
			while((line = br.readLine())!= null) {
			String [] about = line.split(":");
			//System.out.println("about string in login is: " + about.length);
			//if(about.length <= 1) {
				//return useR;
		//	}
			if(person.getUserName().equals(about[3]) && person.getPassWord().equals(about[4])) {
					useR.setFirstName(about[1]);
					useR.setLastName(about[2]);
					useR.setUserName(about[3]);
					useR.setBalance(Double.parseDouble(about[5]));
					System.out.println("Welcome " + about[1] + " " + about[2]+ "!" + "\n");
					return useR;
				}
			//else {
				//	System.out.println("Login Failed. Incorrect username/password \n");
			//		useR.setUserName("null");
				//	return useR;
				//}
			System.out.println("Bro thats not the correct account info. Try again. \n");
			return useR;
			}
			
			
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		System.out.println("My guy, you know you can't log in if you haven't made an account right? \n" + "Get to it and enter 2 to make an account!\n");
		return useR;	
}
	
	public User getUser(String userName) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = null;
			User useR = new User();
			while((line = br.readLine())!= null) {
				String [] about = line.split(":");
				if(about[3].equals(userName)) {
					useR.setFirstName(about[1]);
					useR.setLastName(about[2]);
					useR.setUserName(about[3]);
					useR.setPassWord(about[4]);
					useR.setBalance(Double.parseDouble(about[5]));
					return useR;
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
		

}