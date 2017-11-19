package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.rev.pojo.newUser;

public class FileDao implements DAO 
{
	String filename ="src/main/resources/bank.txt";
	File f = new File(filename);
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
	public newUser getUser(String username,String password) 
	{
		// TODO Auto-generated method stub
		newUser u = new newUser();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			
			String line = null;
			while((line = br.readLine())!=null)
			{	
				String[] about = line.split(":");
				int j;
				for(j=3;j<about.length;j++) 
				{
					if(about[j].equalsIgnoreCase(username))
					{
						if(about[j+1].equalsIgnoreCase(password))
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
	public void change(String username,int o) 
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
				int temp;
				for(j=3;j<about.length;j++)
				{
					if(about[j].equalsIgnoreCase(username))
					{
						temp=o+Integer.parseInt(about[j+2]);
						about[j+2]=Integer.toString(temp);

					}
					
				}

				//delete file and replace it
/*				f.delete();
				f.createNewFile();
*/			
				//write old file info
				//error is here

				try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))//true appending not rewriting
				{
					//should not be able to add users with a username that already exists
					//add logic to validate
					StringBuilder strBuilder = new StringBuilder();
					for (int i = 0; i < about.length; i++) 
					{
					   strBuilder.append(":"+about[i]);
					}
					String newString = strBuilder.toString();
					bw.write(newString);
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(about[0]);
					e.printStackTrace();
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
	}

	@Override
	public void Delete(String username, ArrayList<String> a, String update) 
	{
		// TODO Auto-generated method stub	
	
	}
}