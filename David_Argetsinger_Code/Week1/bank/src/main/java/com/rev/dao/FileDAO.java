package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {
		// TODO Auto-generated method stub
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			// all user names are unique ( not able to add another name that
			// exists)
			// add logic to validate! inside of service layer (buisiness)

			bw.write(u.toFile());
			return u;
			// when you're adding data to area, you want to return
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username) {
		return null;
	}

	/**
	 * update user will take in a username and the new balance 
	 * the username will be used to find the row of information associated with the account 
	 *  and replace the line read in with a new string array with the  new data 
	 */
	@Override
	public User updateUser(String userName, double update) {
		User u = new User();
		String filename = "src/main/resources/bank.txt";
		// System.out.println(" trying my best in update ");
		try {
			// ArrayList<String> [] limited = new [] ArrayList<String>();
			ArrayList<String[]> fileHold = new ArrayList<String[]>();
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String[] limited;
			String line;
			while ((line = br.readLine()) != null) {
				limited = line.split(":");

				if (limited[3].equals(userName)) {
					limited[5] = String.valueOf(update);
					u.setId(Integer.parseInt(limited[0]));
					u.setFirstName(limited[1]);
					u.setLastName(limited[2]);
					u.setUsername(limited[3]);
					u.setPassword(limited[4]);
					u.setBalance(Double.parseDouble(limited[5]));
				}
				fileHold.add(limited);
			}
			// System.out.println(" trying my best after finding my account ");
			fr.close();
			// UPDATE THE FILE NOW
			////// write to file
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
				// all user names are unique ( not able to add another name that
				// exists)
				// add logic to validate! inside of service layer (buisiness)

				for (int i = 0; i < fileHold.size(); i++) {
					for (int j = 0; j < 6; j++) {
						bw.write((fileHold.get(i)[j]) + ":");
					}
					bw.write("\n");
				}
				// System.out.println("trying my best before rturning ");
				return u;
				// when you're adding data to area, you want to return
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// while(br.readLine()== null) {
			// limited.add(br.readLine());
			// if (limited[3].equals(userName))
			// {
			// System.out.println("Updating balance ....");
			// limited[5]=String.valueOf(update);
			//
			// br.close();
			// }
			// }
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
