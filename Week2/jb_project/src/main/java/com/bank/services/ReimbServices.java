package com.bank.services;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DAOimpl;
import com.bank.pojos.Employee;

public class ReimbServices {

	static DAO dao = new DAOimpl();		
	
	
	public void getAllUsers() {
	
		ArrayList<Employee> x = new ArrayList<>();
		x = dao.getAllUsers();

		for(Employee get : x) {
			System.out.println(get.toFile());
		}
		
	}

	public Employee validateUser(String username) {
		ArrayList<Employee> x = new ArrayList<>();

		x = dao.getAllUsers();
		for(Employee get : x) {
			
			if(get.getUserName().equals(username)) {
				System.out.println("Match");

				return get;
			}

		}
		
		return null;
	}

	public Employee addUser(Employee u) {
		ArrayList<Employee> x = new ArrayList<>();
		x.add(u);
		dao.registerUser(x);
		return null;
	}

	
}
