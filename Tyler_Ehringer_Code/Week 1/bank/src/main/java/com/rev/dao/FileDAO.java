package com.rev.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rev.pojos.User;

public class FileDAO implements DAO {

	static String filename = "src/main/resources/bank.txt";
	
	@Override
	public void writeUsers(List<User> users) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))){
			for(User u : users) {
				bw.write(u.toFileString() + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			users = br.lines().map(l -> {
				String[] data = l.trim().split(":");
				return new User(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
			}).collect(Collectors.toCollection(ArrayList::new));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}
