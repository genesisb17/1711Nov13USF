package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojo.newUser;

public class FileDao implements DAO 
{
	String filename ="src/main/resources/bank.txt";
	public void addUser(newUser u) {
		// TODO Auto-generated method stub
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))//true appending not rewriting
		{
			//should not be able to add users with a username that already exists
			//add logic to validate

			bw.write(u.toFile());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public newUser getUser(String username) 
	{
		// TODO Auto-generated method stub
		newUser u = new newUser();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			
			String line = null;
			while((line = br.readLine())!=null)
			{
				//newUser v = new newUser();
				
				String[] about = line.split(":");
				int j;
				for(j=3;j<about.length;j++) 
				{
					if(about[j].equalsIgnoreCase(username))
					{
						u.setFirstname(about[j-2]);
						u.setLastname(about[j-1]);
						u.setUsername(about[j]);
						u.setPassword(about[j+1]);
						u.setBalance(Double.parseDouble(about[j+2]));	
						return u;
					}
				}

				
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
	}
		return u;
	}

	@Override
	public void DeleteUser(String username) 
	{
		// TODO Auto-generated method stub
		
	}

}