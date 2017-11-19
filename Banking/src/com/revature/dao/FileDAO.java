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
//		HashMap<String, String[]> userMap = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while((iine = br.readLine()) != null) {
			String[] temp = iine.split(":");
//			vals.append(temp[1] + "" temp[2] + temp[3] + temp[4]);
//			
//			userMap.put(temp[0],vals);
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
		boolean mat = false;
		ArrayList<String> uPass = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			while((token = br.readLine()) != null) {
				
			String[] izer = token.split(":");
			
//			System.out.println("u User: " + u);
//
//			System.out.println("uPass user: " + uPass.get(2));
//			
//			System.out.println("p Pw: " + p);
//			System.out.println("uPass pw: " + uPass.get(3));
			if((izer[2].equals(u)) && izer[3].equals(p)) {
				
//				System.out.println("Username/password invalid or mismatched.");
//				mat = false;
				
				uPass.add(0, izer[0]);
				uPass.add(1, izer[1]);
				uPass.add(2, izer[2]);
				uPass.add(3, izer[3]);
				uPass.add(4, izer[4]);
				System.out.println("Username/Password match!");
				System.out.println("Username: " + u + " has password "
						+ p + ".");
				mat = true; 
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


}
