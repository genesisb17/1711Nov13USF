package com.rev.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//import com.rev.io.Student;
import com.rev.pojos.User;

public class FileDAO implements DAO{
	
	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			//true means appending, not rewriting
			//should not be able to add users with a username that already exists.
			//add logic to validate inside service aka business layer
			User last = new User();
			int newID = 0;
			//try{
				last = getLastUser();
				if (last == null) newID = 0;
				else 			  newID = last.getId() + 1;
				
			//}
			//catch(NullPointerException e) {
				//newID = 0;
			//}
			
			u.setId(newID);

			bw.write(u.toFile());
			bw.newLine();
			return u;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * getLastUser returns the last user in the 
	 * bank.txt file, and null if the file is empty
	 * 
	 */
	public User getLastUser() {
		String result = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			
			while((line = br.readLine())!=null) {
				result = new String(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String fields[];
		try {
			 fields = result.split(":");
		}
		catch(NullPointerException e) {
			return null;
		}
		return(new User( Integer.parseInt(fields[0]),fields[1],fields[2],
				fields[3],fields[4],Double.parseDouble(fields[5]) ) );
			
	}

	
	public User getUser(String username) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] fields = line.split(":");
				
				if(fields[3].equalsIgnoreCase(username)) {
					return(new User( Integer.parseInt(fields[0]),fields[1],fields[2],
							fields[3],fields[4],Double.parseDouble(fields[5]) ) );
				}
				
			}
			
		}catch(FileNotFoundException fne) {
			fne.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return null;
	}

	
	public User changeBalance(User u, boolean c, double d) {
		
		ArrayList<User> Accounts = new ArrayList<User>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] fields = line.split(":");
				
				Accounts.add(new User( Integer.parseInt(fields[0]),fields[1],fields[2],
							fields[3],fields[4],Double.parseDouble(fields[5]) ) );				
			}
			
			for (User au : Accounts) {
				if (u.equals(au)) {
					double bal = au.getBalance();
					bal += (c ? d : (d * -1));
					au.setBalance(bal);
					u = au;
				}
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false));){
			for (User au : Accounts) {
				bw.write(au.toFile());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}//end changeBalance
	
}

	

