package com.real.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.real.util.ConnectionFactory;
import com.real.dao.DAO;
import com.real.dao.FileDAO;
import com.real.pojos.User;

public class Service {
	
	static ArrayList<String> people = new ArrayList<String>();
	static {
		people.add("Gen");
		people.add("test");
		people.add("another person");
		people.add("testing");
	}
	
	public ArrayList<String> getUsers() {
		return people;
	}
	public String getUserByID(int id) {
		return people.get(id);
	}
	
	public void addUser(String user) {
		people.add(user);
	}
}