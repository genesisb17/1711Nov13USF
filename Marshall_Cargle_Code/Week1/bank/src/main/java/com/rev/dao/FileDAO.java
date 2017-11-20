package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;

/**
 * @author Marshall
 * FileDAO is used whenever the program has to act on the bank.txt file
 */
public class FileDAO implements DAO {

	/**
	 * filename of where the date is saved
	 */
	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {
		int tempID=0;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			// should not be able to add users with a username that already exists
			// add logic to validate inside of service AKA business layer
			try(BufferedReader br = new BufferedReader(new FileReader(filename))){
				String line = null;
				while((line = br.readLine())!=null) {
					String[] about = line.split(":");
					User temp = new User(Integer.parseInt(about[0]), about[1], about[2], about[3], about[4],
							Double.parseDouble(about[5]));
					tempID++;
				}
			}
			u.setId(tempID);
			bw.write(u.toFile());
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(User u) {
		ArrayList<User> users = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine())!=null) {
				String[] about = line.split(":");
				User temp = new User(Integer.parseInt(about[0]), about[1], about[2], about[3], about[4],
						Double.parseDouble(about[5]));
				users.add(temp);
			}
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getEmail().equals(u.getEmail()))
					users.set(i, u);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
			for (User temp : users)
				try {
					bw.write(temp.toFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public User getUser(String email) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine())!=null) {
				String[] about = line.split(":");
				if (about[3].equals(email)) {
					User u = new User();
					u.setId(Integer.parseInt(about[0]));
					u.setFirstname(about[1]);
					u.setLastname(about[2]);
					u.setEmail(about[3]);
					u.setPassword(about[4]);
					u.setBalance(Double.parseDouble(about[5]));
					return u;
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
