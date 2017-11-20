package com.revature.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.revature.pojo.User;

public class FileDAO implements DAO{
	String filename = "src/logs/user.txt";
	@Override
	public User addUser(User u) {

		// TODO Auto-generated method stub
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){

			bw.append(u.toFile());
			//bw.write(u.toString());
			return u;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<String> getUser() {
		// TODO Auto-generated method stub
		String iine = null;
		ArrayList<String> userKey = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while((iine = br.readLine()) != null) {
			String[] temp = iine.split(":");

			userKey.add(temp[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userKey;
	}
	
	public ArrayList<String> logOn(String u, String p) {
		String token = null;
		ArrayList<String> uPass = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while((token = br.readLine()) != null) {
				
			String[] izer = token.split(":");
			
			if((izer[2].equals(u)) && izer[3].equals(p)) {
				

				uPass.add(0, izer[0]);
				uPass.add(1, izer[1]);
				uPass.add(2, izer[2]);
				uPass.add(3, izer[3]);
				uPass.add(4, izer[4]);
				System.out.println("Username/Password match!");
				System.out.println("Username: " + u + " has password "
						+ p + ".");
				return uPass;
				}


			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;				
	
	}
	
	public User makeTransac(double amount, double curBal) {
		String cheese = null;
		String cheese2 = null;
		User so = new User();
		double match;
		Double newBalance;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){

				while((cheese = br.readLine()) != null) {
					String[] wine = cheese.split(":");
							try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){
								match = Double.parseDouble(wine[4]);
								so.setUsername(wine[2]);
								so.setFirstname(wine[0]);
								so.setLastname(wine[1]);
								so.setPassword(wine[3]);
	
								if(match == curBal) {
							
									newBalance = match - amount;
									so.setBalance(newBalance);
									System.out.println("New Balance: " + newBalance);

								}
						
								else {	
									so.setBalance(match);

								}
								bw.write(so.toFile());
								return so;
							}
				}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

//				try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
//					try(BufferedReader read = new BufferedReader(new FileReader(filename))){
//						while((cheese2 = read.readLine()) != null) {
//							String[] wine2 = cheese2.split(":");
//							if() {
//								
//							}
//						}
//						
//					}
//
//							
//
//					}
//				catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return so;

		}
	}

