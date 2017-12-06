package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.BankAccount;
import com.rev.pojos.User2;
import com.rev.util.ConnectionFactory;

public class DAO2Impl implements DAO2 {

	@Override
	public User2 createUserAccount(User2 user) {
		User2 usr = new User2();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD) "
					+ "VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "U_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				usr.setUid(pk.getInt(1));
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}

	@Override
	public ArrayList<User2> getUsers() {
		ArrayList<User2> users = new ArrayList<User2>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User2 temp = new User2();
				temp.setUid(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUserName(rs.getString(4));
				temp.setPassword(rs.getString(5));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ArrayList<BankAccount> getUsersBankAccounts(User2 user) {
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		int uid = user.getUid();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from ACCOUNTS where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BankAccount ba = new BankAccount();
				ba.setAccountID(rs.getInt(1));
				ba.setUserID(rs.getInt(2));
				ba.setBalance(rs.getDouble(3));
				accounts.add(ba);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public User2 getUserById(int uid) {
		User2 usr = new User2();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUid(info.getInt(1));
				usr.setFirstName(info.getString(2));
				usr.setLastName(info.getString(3));
				usr.setUserName(info.getString(4));
				usr.setPassword(info.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}


	@Override
	public BankAccount getBankAccountById(int aid) {
		BankAccount ba = new BankAccount();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "select * from ACCOUNTS where ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				ba.setAccountID(info.getInt(1));
				ba.setUserID(info.getInt(2));
				ba.setBalance(info.getDouble(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ba;
	}

	
	@Override
	public User2 getUserByUnameAndPassword(String userName, String password) {
		User2 usr = new User2();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUid(info.getInt(1));
				usr.setFirstName(info.getString(2));
				usr.setLastName(info.getString(3));
				usr.setUserName(info.getString(4));
				usr.setPassword(info.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	

	@Override
	public double adjustBalance(BankAccount bankAccount, double amount) {
		int aid = bankAccount.getAccountID();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "UPDATE ACCOUNTS SET balance = ? WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setInt(2, aid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public BankAccount createBankAccount(BankAccount account) {
		BankAccount ba = new BankAccount();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] key = new String[1];
			key[0] = "ACC_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, account.getUserID());
			ps.setDouble(2, account.getBalance());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				ba.setAccountID(pk.getInt(1));
			}
			conn.commit();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ba;
	}

	@Override
	public User2 getUserByUname(String userName) {
		User2 usr = new User2();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUid(info.getInt(1));
				usr.setFirstName(info.getString(2));
				usr.setLastName(info.getString(3));
				usr.setUserName(info.getString(4));
				usr.setPassword(info.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

}
