package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class FileDAO implements DAO {

	String filename = "src/main/resources/bank.txt";

	public User addUser(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "u_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					u.setId(pk.getInt(1));
				}
				ps.close();
				conn.commit();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addAccount(u);
		return null;
	}

	public void addAccount(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into accounts(user_id, balance) values(?, ?)";
			String[] key = new String[1];
			key[0] = "user_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, u.getId());
			ps.setDouble(2, u.getBalance());
			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					u.setId(pk.getInt(1));
				}
				ps.close();
				conn.commit();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateUser(User x, int account_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE accounts SET balance =? WHERE user_ID =? AND ACC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, x.getBalance());
			ps.setInt(2, x.getId());
			ps.setInt(3, account_id);
			ps.executeUpdate();
			ps.close();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User getUser(String username) {
		User u = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "select * from users left outer join ACCOUNTS on ACCOUNTS.USER_ID=USERS.U_ID WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// index going by number of ?s
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
			}
			ps.close();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please enter your password");
		Scanner scan = new Scanner(System.in);
		String pw = scan.nextLine();
		if (!(u.getPassword().equals(pw))) {
			do {
				System.out.println("Incorrect Password. Please Try Again: ");
				pw = scan.nextLine();
			} while (!(u.getPassword().equals(pw)));
		}
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "select acc_id, balance from accounts where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			Account acc;
			System.out.println("Here are your accounts: ");
			while (info.next()) {
				acc = new Account();
				acc.setAccount_id(info.getInt(1));
				acc.setBalance(info.getDouble(2));
				System.out.println(acc.toString());
			}
			ps.close();
			conn.commit();
			conn.close();
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Name: " + u.getFirstname() + " " + u.getLastname() + "\n" + "Username: " + u.getUsername()
				+ "\n" + "Password: " + u.getPassword() + "\n");
		
		System.out.println("Would you like to Create a New Account(1), Deposit to an Existing Account(2), or Withdraw from an Existing Account(3)");
		int op = scan.nextInt();
		switch (op) {
		case 1:
			addAccount(u);
			System.out.println("Your new account has been created!");
			break;
		case 2:
		System.out.println("Which account would you like to access? ");
		int account = scan.nextInt();
		System.out.println("How much money will you be depositing? ");
		double deposit = scan.nextDouble();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "select balance from accounts where USER_ID = ? AND acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setInt(2, account);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u.setBalance(info.getDouble(1) + deposit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateUser(u, account);
		System.out.println("Your new balance is " + u.getBalance());
		break;
		case 3:
			System.out.println("Which account would you like to access? ");
			int acc = scan.nextInt();
			System.out.println("How much money will you be withdrawing? ");
			double wd = scan.nextDouble();
			try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
				conn.setAutoCommit(false);
				String sql = "select balance from accounts where USER_ID = ? AND acc_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, u.getId());
				ps.setInt(2, acc);
				ResultSet info = ps.executeQuery();
				while (info.next()) {
					u.setBalance(info.getDouble(1) - wd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updateUser(u, acc);
			System.out.println("Your new balance is " + u.getBalance());
			break;
		}
		
		return u;
	}
}