package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojos.User;

public class FileDAO implements DAO{
		
		static String fileName = "src/main/resources/bank.txt";
	
	
	public User updateMoney(User person, String inputStr) {
		FileOutputStream fileOut;
		try {
	//		System.out.println("In the deposit money fil dao , str is: \n" + inputStr);
			fileOut = new FileOutputStream(fileName);
			fileOut.write(inputStr.getBytes());
			//fileOut.write(b);
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return person;
	}
	public User addUser(User person) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))) {
			bw.write(person.toFile()); // will write to 
			bw.newLine();
			return person;
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
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
