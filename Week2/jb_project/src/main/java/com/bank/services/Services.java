package com.bank.services;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.bank.dao.DAO;
import com.bank.dao.DAOimpl;
import com.bank.pojos.Users;

public class Services {
	Scanner scan = new Scanner(System.in);
	
	public String inputChk() {
		String input = scan.nextLine();
		if((!input.isEmpty()) && StringUtils.isAlphanumeric(input)) {
			
			return input;
		}
		
		System.out.println("Input must be alphanumeric and cannot be empty.\n"
				+ "Please try again.");
		return inputChk();
	}
	public String isAlpha() {
		String name = scan.nextLine();
		if((!name.isEmpty()) && name.matches("[a-zA-Z]+")) {
			return name;
		}
		System.out.println("Name must only contain characters and cannot be empty.\n"
				+ "Please try again.");
		return isAlpha();
	}
	public Users addaUser() {
		DAO dao = new DAOimpl();
		Users u = new Users();
		ArrayList<String> info = new ArrayList<>();
		System.out.println("Please enter a first name:");
		String first = isAlpha();
		System.out.println("Please enter a last name:");
		String last = isAlpha();
		System.out.println("Please enter a username (not case-sensitive):");
		String uname = inputChk();
		System.out.println("Please enter a password:");
		String pswrd = inputChk();

		info.add(first);
		info.add(last);
		info.add(uname);
		info.add(pswrd);
		//System.out.println(info);
		dao.addUser(info);

		return u;
	}
	
	public Users logIn() {
		DAO dao = new DAOimpl();
		Integer veri = new Integer(1);
		System.out.println("Please enter your username (not case-sensitive):");
		String una = inputChk();
		System.out.println("Please enter your password:");
		String pw = inputChk();
		veri = dao.logOn(una, pw);
		
		if(veri == null) {
			return logIn();
		}
			
		System.out.println(veri);
		return null;
	}
	
	
	public void transac(Integer veri) {
		// TODO Auto-generated method stub
		System.out.println("You are now in transac.");
	}
	
}
