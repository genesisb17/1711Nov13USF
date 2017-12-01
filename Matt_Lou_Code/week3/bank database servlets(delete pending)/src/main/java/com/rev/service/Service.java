package com.rev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ex.util.ConnectionFactory;
import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new FileDAO();
	
	public User addUser(User u) {
		// validate that username does not exist
		// assuming that it does not exist:
		dao.addUser(u);
		return u;
	}
	
	public User callUpdate(User u) {
		dao.update(u);
		return u;
	}
	
	public void login() {
		
		String username = "";
		String password = "";
		System.out.println("Please enter your Username and password to log in.");
		Scanner scan = new Scanner(System.in);
		username = scan.nextLine();
		password = scan.nextLine();
		User user = new User();
	
		String str = "";

		boolean found = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from users where username = ? and password = ?";
			String sql2 = "Select * from accounts where USER_ID = ?";
			//String[] key = {"U_ID"};
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(4).equals(username) &&  rs.getString(5).equals(password)) {
					found = true;
					user.setId(rs.getInt(1));
					user.setFirstname(rs.getString(2));
					user.setLastname(rs.getString(3));
					// get user ID and match that to the account table
					
					ps2.setInt(1, user.getId());
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()) {
						user.setBalance(rs2.getDouble(3));
					}
					userMenu(user);
				}
				if(!found)
				System.out.println("User not found.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public User createAccount() {
		
		System.out.println("Welcome! Please enter your first name");
		String info = "";
		Scanner scan = new Scanner(System.in);
		info = scan.nextLine();
		User u = new User();
		
		u.setFirstname(info);
		
		System.out.println("Please enter your last name");	
		info = scan.nextLine();
		u.setLastname(info);
		
		System.out.println("Create a username for log in");
		info = scan.nextLine();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				if(rs.getString(4).equals(info)) {
					System.out.println("This username already exists. Please start over.");
					run();
				
				}
			}
			u.setUsername(info);
			System.out.println("Create a password for log in.");
			info = scan.nextLine();
			u.setPassword(info);
//			String sql2 = "select * from accounts";
//			rs = statement.executeQuery(sql2);
			//deposit $$
			u.setBalance(0);
			addUser(u);
			System.out.println("Your account has been created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}
	
	public void userMenu (User user) {
		
		System.out.println("Would you like to view balance(1), withdraw(2), "
				+ "deposit(3) or log out(4)"  + "?");
		Scanner scan = new Scanner(System.in);
		String option = scan.nextLine();
		switch(option) {
		case"1": System.out.println("Your current balance is: " + user.getBalance());
			userMenu(user);
		break;
		case"2": System.out.println("How much would you like to withdraw?");
			Scanner scan1 = new Scanner(System.in);
			String bal = "0.0";
			bal = scan1.nextLine();
			if(user.getBalance() > Double.parseDouble(bal)) {
				user.setBalance(user.getBalance() - Double.parseDouble(bal));
				callUpdate(user);
				userMenu(user);
				
			}else {
				System.out.println("You do not have enough in your account.");
				userMenu(user);
			}
				
		break;
		case"3": System.out.println("How much would you like to deposit?");
			Scanner scan11 = new Scanner(System.in);
			bal = "0.0";
			bal = scan11.nextLine();
			user.setBalance(user.getBalance() + Double.parseDouble(bal));
//			User newinfo = new User();
//			newinfo = service.callUpdate(newinfo);
//			userMenu(newinfo);
			callUpdate(user);
			userMenu(user);
		case"4": System.out.println("You have logged out.");
			run();
		}
		
	}
	
	public void run() {
		System.out.println("Welcomme to BondsBank\n Would you like to log in(1) or Create Account(2)");

		Scanner scan = new Scanner(System.in);
		String op = scan.nextLine();
		switch (op) {
		case "1": login();
			break;
		case "2":
			createAccount();
			break;
		default:
			run();
		}
	}
}



