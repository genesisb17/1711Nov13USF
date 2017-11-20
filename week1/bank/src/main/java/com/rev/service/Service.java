package com.rev.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;
import com.rev.run.RunBank;

public class Service {

	private static DAO dao = new FileDAO();
	private static final String filename="src/main/resources/bank.txt";

	public void addUser(User u) {
		//validate that username does not exist
		boolean exists=false;
		try(BufferedReader br=new BufferedReader(new FileReader(filename))){
			String line;
			List<User> users=new ArrayList<>();

			while((line=br.readLine())!=null) {
				//empty string lines used to clear out the file, not in user format
				if(!line.equals("")) {
					StringTokenizer tok=new StringTokenizer(line,":");
					int id=Integer.parseInt(tok.nextToken());
					String fn=tok.nextToken();
					String ln=tok.nextToken();
					String user=tok.nextToken();
					String pass=tok.nextToken();
					double bal=Double.parseDouble(tok.nextToken());
					User checkUser=new User(id,fn,ln,user,pass,bal);
					users.add(checkUser);
					if(checkUser.getUsername().equals(u.getUsername())) {
						exists=true;	
					}
				}
			}

			//clear out text file
			BufferedWriter cleared=new BufferedWriter(new FileWriter(filename,false));
			cleared.write("");
			cleared.close();

			//add back users to data.txt
			while(!users.isEmpty()) {
				dao.addBackUser(users.remove(0));
			}

			//add new user if username does not exist
			if(!exists) {
				dao.addNewUser(u);
			} else {
				System.out.println("User already exists.");
				RunBank.run();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void updateUser(User u) {
		dao.addBackUser(u);
	}

	public User validateLogin(String user, String pass) {
		User u=dao.getUser(user);
		if(!u.getUsername().equals("")) {
			if(!u.getPassword().equals(pass)) {
				System.out.println("Wrong password.");
				u=new User();
				RunBank.run();
			}
		} else {
			System.out.println("User does not exist.");
			RunBank.run();
		}
		return u;
	}
}
