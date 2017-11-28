package com.rev.run;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;
import com.rev.util.ConnectionFactory;

public class RunBank {

	static Service service = new Service();

	public static void main(String[] args) {

		run();

	}

	static void run() {
		boolean run = true;
		while (run == true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to Gringotts\nWould you like to Log in(1) or Create Account(2) or Exit(3)");
			String op = scan.nextLine();

			switch (op) {
			case "1":
				login();
				break;
			case "2":
				createAccount();
				break;
			case "3":
				run=false;
				break;
			default:
				run();
			}
		}
	}

	static User login() {
		System.out.println("Please enter your username: ");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		return service.getUser(username);
	}

	static User createAccount() {
		String un = " ";

		System.out.println("Awesome! Welcome! Please enter your first name");
		User u = new User();
		Scanner scan = new Scanner(System.in);
		String fn = scan.nextLine();
		u.setFirstname(fn);
		System.out.println("Please enter your last name: ");
		String ln = scan.nextLine();
		u.setLastname(ln);
		System.out.println("Please enter your desired username: ");
		un = scan.nextLine();
		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select username from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User temp = new User();
				temp.setUsername(rs.getString(1));
				users.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User x : users)
			if (un.equals(x.getUsername())) {
				System.out.println("Username already exists.");
				do {
					System.out.println("Please enter another username: ");
					un = scan.nextLine();
				} while (un.equals(x.getUsername()));
			}
		u.setUsername(un);
		System.out.println("Please enter a password for your account");
		String pw = scan.nextLine();
		u.setPassword(pw);
		System.out.println("Account has been created.");
		service.addUser(u);
		return u;
	}

}
