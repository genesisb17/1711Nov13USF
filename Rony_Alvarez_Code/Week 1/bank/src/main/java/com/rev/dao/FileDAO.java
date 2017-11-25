package com.rev.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.connection.ConnectionFactory;
import com.rev.pojos.User;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";

	public User registerUser(User u) {
			
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			int rows = ps.executeUpdate();
			
			if(rows >= 1) {
				
				System.out.println("Account created successfully!");
						
			} else {
				
				System.out.println("There was a problem creating the new account. Please try again later.");
				
			}
						
			conn.commit();
			
		} catch (SQLException e) {
			
			System.out.println("There was a problem creating the new account. Please try again later.");

		}
		
		return null;
	}

	public User login(String username, String password) {

		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT U_ID, FIRSTNAME FROM USERS WHERE USERNAME = LOWER(?) AND PASSWORD = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			while(info.next()) {
				
				user.setId(info.getInt("U_ID"));
				user.setFirstname(info.getString("FIRSTNAME"));
			
			}		

		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}

		return user;
	}

	@Override
	public User depositMoney(int accountId, double balance, double deposit) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			double newBalance = balance + deposit;
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACC_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, accountId);

			int rows = ps.executeUpdate();
			
			if (rows >= 1) {

				System.out.println("The money was added to your account successfully! Your new balance is: " + newBalance + "\nThank you for being a loyal customer!\n");

			} else {

				System.out.println("There was a problem adding the money to the account. Please try again later.");

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem adding the money to your account. Please try again later.");

		}

		return null;
	}

	@Override
	public ArrayList<User> getBalance(int userId) {

		ArrayList<User> accounts = new ArrayList<>(); 
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "SELECT ACC_ID, BALANCE FROM ACCOUNTS WHERE USER_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				User temp = new User();
				temp.setId(rs.getInt("ACC_ID"));
				temp.setBalance(Double.parseDouble(rs.getString("BALANCE")));
				accounts.add(temp);
			}
			
			if(accounts.get(0) == null) {};
			
			for(User account: accounts) {
				
				System.out.println("Account Id: " + account.getId() + ", Balance: " + account.getBalance());
				
			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem getting your balance. Please try again later.\n");

		} catch (IndexOutOfBoundsException o) {
			
			System.out.println("There are no accounts associated with this user.\n");
			
		}

		return accounts;

	}

	static void modifyFile(String filePath, String oldString, String newString) {
		
		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			
			}

			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceFirst(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		} finally {
			
			try {
				
				// Closing the resources
				reader.close();
				writer.close();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
		}
	}

	@Override
	public User withdrawMoney(int accountId, double balance, double deposit) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			double newBalance = balance - deposit;
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACC_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, accountId);

			int rows = ps.executeUpdate();
			
			if (rows >= 1) {

				System.out.println("The money was removed from your account successfully! Your new balance is: " + newBalance + "\nThank you for being a loyal customer!\n");

			} else {

				System.out.println("There was a problem removing the money from the account. Please try again later.");

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem removing the money from your account. Please try again later.");

		}

		return null;
	}

	@Override
	public User getUserById(int id) {
		
		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from users where u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				
				user.setId(info.getInt(1));
				user.setFirstname(info.getString(2));
				user.setLastname(info.getString("lastname"));
				user.setUsername(info.getString("username"));
				user.setPassword(info.getString("password"));
			
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}

		return user;
	}

	public User createAccount(int userId, double initialBalance) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);

			String sql = "INSERT INTO ACCOUNTS (ACCOUNTS.USER_ID, BALANCE) VALUES (?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDouble(2, initialBalance);

			int rows = ps.executeUpdate();

			if (rows >= 1) {

				System.out.println("Account created successfully!\n");

			} else {

				System.out.println("There was a problem creating the new account. Please try again later.");

			}

			conn.commit();

		} catch (SQLException e) {

			System.out.println("There was a problem creating the new account. Please try again later.\n");

		}

		return null;
	}

	@Override
	public User getBalanceById(int id) {
		
		User user = new User();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT BALANCE FROM ACCOUNTS WHERE ACC_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				
				user.setBalance(info.getInt(1));
			
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}

		return user;
		
	}

}
