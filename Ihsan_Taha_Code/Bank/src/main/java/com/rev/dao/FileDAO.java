package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	String fileName = "src/main/resources/bank.txt";

	public boolean addUser(User user) {

		if (checkIfUserExists(user))
			return true;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
			bw.write(user.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public User getUser(User u) {

		boolean userFound = false;

		ArrayList<User> users = new ArrayList<>();
		users = getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			if (u.getUserName().equals(users.get(i).getUserName())
					&& u.getPassWord().equals(users.get(i).getPassWord())) {
				u.setFirstName(users.get(i).getFirstName());
				u.setLastName(users.get(i).getLastName());
				u.setBalance(users.get(i).getBalance());
				userFound = true;
				break;
			}
		}

		if (userFound)
			return u;
		else
			return null;
	}

	public void updateUser(User user) {
		ArrayList<User> users = new ArrayList<>();
		users = getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			if (user.getUserName().equals(users.get(i).getUserName())) {
				updateFile(users.get(i), user);
				users.get(i).setBalance(user.getBalance());
				System.out.println("Your balance has been updated");
				break;
			}
		}
	}

	public void deleteUser(User user) {

		ArrayList<User> users = new ArrayList<>();
		users = getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			if (user.getUserName().equals(users.get(i).getUserName()))
				users.remove(users.get(i));
		}

		StringBuffer inputBuffer = new StringBuffer();

		for (int i = 0; i < users.size(); i++) {
			inputBuffer.append(users.get(i).toString());
		}

		String inputStr = inputBuffer.toString();
		
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			fileOut.write(inputStr.getBytes());
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> getAllUsers() {
		ArrayList<User> usersOnFile = new ArrayList<>();

		try (BufferedReader usersFromFile = new BufferedReader(new FileReader(fileName));) {
			String line = null;
			while ((line = usersFromFile.readLine()) != null) {
				String[] lineFromFile = line.split(",");
				User userFromFile = new User();
				userFromFile.setFirstName(lineFromFile[0]);
				userFromFile.setLastName(lineFromFile[1]);
				userFromFile.setUserName(lineFromFile[2]);
				userFromFile.setPassWord(lineFromFile[3]);
				userFromFile.setBalance(Double.parseDouble(lineFromFile[4]));
				usersOnFile.add(userFromFile);
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return usersOnFile;
	}

	public boolean checkIfUserExists(User user) {

		ArrayList<User> users = new ArrayList<>();
		users = getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			if (user.getUserName().equals(users.get(i).getUserName()))
				return true;
		}

		return false;
	}

	public void updateFile(User oldUser, User newUser) {
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line, inputStr = "";
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
				inputStr = inputBuffer.toString();
				if (inputStr.contains(oldUser.toString())) {
					inputStr = inputStr.replaceAll(oldUser.toString(), newUser.toString());
				}
			}

			FileOutputStream fileOut = new FileOutputStream(fileName);
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
