package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class OracleDAO implements DAO {

	@Override
	public ArrayList<User> getUsers() {

		ArrayList<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from users";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setFirstname(rs.getString(2));
				temp.setLastname(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				users.add(temp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public User addUser(User user) {
		User temp = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false to make sure it has properly changed
			String sql = "insert into users (firstname, lastname, username, password) values (?, ?, ?, ?)"; // JDBC can
																											// handle
																											// the ""
																											// for you
			String[] key = new String[1];
			key[0] = "u_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			int rows = ps.executeUpdate(); // could set variable to track that the update happened
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					temp.setId(pk.getInt(1));
				}
				temp.setFirstname(user.getFirstname());
				temp.setLastname(user.getLastname());
				temp.setUsername(user.getUsername());
				temp.setPassword(user.getPassword());
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public ArrayList<Account> getAccounts(User user) {

		ArrayList<Account> Accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from accounts where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account temp = new Account();
				temp.setAcc_id(rs.getInt(1)); // Index starts at 1
				temp.setUser_id(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Accounts;
	}

	@Override
	public Account getAccount(int acc) {
		Account account = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from accounts where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account.setAcc_id(rs.getInt(1));
				account.setUser_id(rs.getInt(2));
				account.setBalance(rs.getDouble(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	public Account createAccount(User user) {
		Account temp = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false to make sure it has properly changed
			String sql = "insert into accounts (user_id, balance) values (?, ?)"; // JDBC can handle the "" for you
			String[] key = new String[1];
			key[0] = "acc_id";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, user.getId());
			ps.setDouble(2, 0.00);
			int rows = ps.executeUpdate(); // could set variable to track that the update happened
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					temp.setAcc_id(pk.getInt(1));
				}
				temp.setUser_id(user.getId());
				temp.setBalance(0.00);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public Account updateDeposit(Account account, double dep) {
		Account acc = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false if want to make sure it has properly changed something before
										// commit
			String sql = "update accounts set balance = ? where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance() + dep); // First number is which ?, 2nd is value passed
			ps.setInt(2, account.getAcc_id());

			int rows = ps.executeUpdate();
			// ps.executeUpdate();
			if (rows != 0) {
				acc.setAcc_id(account.getAcc_id());
				acc.setUser_id(account.getUser_id());
				acc.setBalance(account.getBalance() + dep);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	@Override
	public Account updateWithdraw(Account account, double wd) {
		Account acc = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false if want to make sure it has properly changed something before
										// commit
			String sql = "update accounts set balance = ? where acc_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance() - wd); // First number is which ?, 2nd is value passed
			ps.setInt(2, account.getAcc_id());

			int rows = ps.executeUpdate();
			// ps.executeUpdate();
			if (rows != 0) {
				acc.setAcc_id(account.getAcc_id());
				acc.setUser_id(account.getUser_id());
				acc.setBalance(account.getBalance() - wd);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

}
