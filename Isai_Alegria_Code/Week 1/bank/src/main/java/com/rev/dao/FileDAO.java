package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.rev.pojos.User;

public class FileDAO implements DAO{

	
	String filename = "src/main/resources/bank.txt";
	public User addUser(User u) {
																	//true means appending
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
			//should not be able to add users with a username that already exists
			
			
			bw.write(u.toFile());
			bw.write("\n");
			
			return u;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public double deposit(double amount,String user) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
		
			double initialBalance, newBalance;
			String line = null;
			line = br.readLine();
			String[] holder = line.split(":");
			initialBalance = Double.parseDouble(holder[5]);
			newBalance = initialBalance + amount;
			
			String initialBalanceStr = initialBalance + "";
			String newBalanceStr = newBalance + "";
			
			modifyFile(filename,initialBalanceStr,newBalanceStr,user);
			
			System.out.println("Your new balance is: " + newBalance);
			
			return newBalance;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public void viewBalance() {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			double temp;
			String line = null;
			line = br.readLine();
			String[] holder = line.split(":");
			temp = Double.parseDouble(holder[5]);
			System.out.println(temp);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void withdraw(double amount,String user) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			
			double initialBalance, newBalance;
			String line = null;
			line = br.readLine();
			String[] holder = line.split(":");
			initialBalance = Double.parseDouble(holder[5]);
			newBalance = initialBalance - amount;
			
			
			String initialBalanceStr = initialBalance + "";
			String newBalanceStr = newBalance + "";
			
			modifyFile(filename,initialBalanceStr,newBalanceStr,user);
			
			System.out.println("New balance is: " + newBalance);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
		//function to find if username is in existence, returns true is it is
		//or false if it is not. used for login function.
		public boolean getUser(String username, String password) {
		
		boolean flag = false;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			String line = null;
			while((line = br.readLine()) != null) {
				
				//System.out.println("read from text file: " + line);
				String[] holder = line.split(":");
				String user = holder[1];
				String pass = holder[4];
				
				if(user.equals(username) && pass.equals(password)) {
					
					System.out.print("Found existing account. ");
					flag = true;
					break;
				}
				
				else {
					flag = false;
				}
				
			}
			
			if(flag == false) {
				System.out.println("Sorry, couldn't find your account.");
			}

			return flag;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
		//function that returns true if username exists or false if not
		//used for creating account
		public boolean findUser(String username) {
			
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] holder = line.split(":");
				
				//System.out.println(holder[1]);
				String user = holder[1];
				
				if(user.equals(username)) {
					
					return true;
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
		
	//function to update text file, 
	static void modifyFile(String filePath, String oldString, String newString, String user)
	{
	     File fileToBeModified = new File(filePath);
	         
	     String oldContent = "";
	         
	     BufferedReader reader = null;
	         
	     FileWriter writer = null;
	         
	     try
	     {
	         reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	         //Reading all the lines of input text file into oldContent
	             
	         String line = reader.readLine();
	             
	         while (line != null) 
	         {
	             oldContent = oldContent + line + System.lineSeparator();
	                 
	             line = reader.readLine();
	          }
	             
	          //Replacing oldString with newString in the oldContent
	            
	         int i = 0;
	         String[] holder = oldContent.split(":");
	         
	         //System.out.println("User: " + user);
	         
	         while(!(holder[i].equals(user))) {
	        	 
	        	// System.out.println(holder[i]);
	        	 i++;
	         }
	         
	         holder[i+4] = newString;
	         
	         StringBuffer str = new StringBuffer ("");
	         
	        // System.out.println("Should be copied to text file: ");
	         for(int j = 0; j < holder.length; j++) {
	        
	        	 //System.out.println(holder[j]);
	        	  str.append(holder[j]);
	        	  str.append(":");
	        	 
	         }
	         
	         //System.out.println("Stringbuffer: " + str);
	         String newContent = "";
	         newContent = str.toString();
	         //System.out.println("string to be written: " + newContent);
	         
	         //String newContent = oldContent.replaceAll(oldString, newString);
	             
	          //Rewriting the input text file with newContent
	             
	         FileOutputStream fileOut;
	         fileOut = new FileOutputStream(fileToBeModified);
	         fileOut.write(newContent.getBytes());
	         
	          //writer = new FileWriter(fileToBeModified);
	             
	          //writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                //writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
		

}
