package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.rev.pojos.User;

public class FileDAO implements DAO {
	
	private static final String filename="src/main/resources/bank.txt";
	
	public void addBackUser(User u) {
		//try-with-resources
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true))){
			bw.write(u.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewUser(User u) {
		//try-with-resources
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true))){
			//should not be able to add users with a username that already exists
			//add logic to validate inside of service AKA business layer
			//have to read in entire text file
			
			//keep IDs unique
			int currentIdnums=User.getIdnums();
			int newIdnums=currentIdnums++;
			User.setIdnums(newIdnums);

			bw.write(u.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getUser(String username) {
		User u=new User();
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
					
					if(checkUser.getUsername().equals(username)) {
						u=checkUser;
					} else {
						users.add(checkUser);
					}
				}
			}
			
			//clear out text file
			BufferedWriter cleared=new BufferedWriter(new FileWriter(filename,false));
			cleared.write("");
			cleared.close();
			
			//add users to cleared out text file
			while(!users.isEmpty()) {
				this.addBackUser(users.remove(0));
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return u;		
	}
}
