package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.User;

public class FileDAO implements DAO {
	
	static String filename = "src/main/resources/bank.txt";

	@Override
	public void writeUsers(List<User> usersList) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
			for (User user : usersList)
				bw.write(user.toFileString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUsers() {
		List<User> usersList = new ArrayList<User> ();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				String[] userData = inputLine.split(":");
				if (userData.length < 6)
					break;
				usersList.add(new User(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3], 
								userData[4], new BigDecimal(userData[5])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
}
