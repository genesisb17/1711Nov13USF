package com.bank.services;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.bank.dao.DAO;
import com.bank.dao.DAOimpl;
import com.bank.pojos.Accounts;
import com.bank.pojos.Employee;
import com.bank.pojos.Users;

public class Services {

/*	Scanner scan = new Scanner(System.in);
	DAO dao = new DAOimpl();
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
		//DAO dao = new DAOimpl();
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
		Users x = new Users();
//		Integer veri = new Integer(1);
		System.out.println("Please enter your username (not case-sensitive):");
		String una = inputChk();
		System.out.println("Please enter your password:");
		String pw = inputChk();
		x = dao.logOn(una, pw);
//		System.out.println(x.toFile());
//		System.out.println(veri);
		if(x.getId() == null) {
			System.out.println("Wrong log-in information."
					+ "\nPlease try again.");
			return logIn();
		}
		System.out.println("Hello! What would you like to do today?");
		System.out.println("CREATE(1) a bank account, VIEW(2) user account number details or LOGOUT(3)?");
		transac(x);
		return null;
	}
	public Integer acAuth(ArrayList<Integer> lis) {
		System.out.println("Please enter a valid account number.");
		Integer aut = scan.nextInt();
		if(lis.contains(aut)) {
			
			return aut;
		}
		System.out.println("Not valid sorry.");
		return acAuth(lis);
	}
	
	public Users transac(Users u) {
		// TODO Auto-generated method stub
		Accounts ac = new Accounts();
		ArrayList<Integer> acid = new ArrayList<>();
		Integer fin = new Integer(1);
		String tk = scan.nextLine();
		switch(tk) {
		case "1":
			dao.addAccount(u.getId());
			System.out.println("Hello! What would you like to do today?");
			System.out.println("CREATE(1) a bank account, VIEW(2) user account number details or LOGOUT(3)?");
			transac(u);
			break;
		case "2" :
			acid = dao.acctDetails(u.getId());
			fin = acAuth(acid);
			ac = dao.makeTransac(fin);
			dao.dOw(ac.getAcctId(), ac.getBalance());
			System.out.println("Hello! What would you like to do today?");
			System.out.println("CREATE(1) a bank account, VIEW(2) user account number details or LOGOUT(3)?");
			transac(u);
			break;
		case "3" :
			System.out.println("You have successfully logged out.");
			break;
		default:
			transac(u);
			break;
		}
		return u;

	}*/

}
