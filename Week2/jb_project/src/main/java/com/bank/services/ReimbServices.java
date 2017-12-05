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
}
