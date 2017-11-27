package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class BankDatabaseDAO implements BankDAO {

	@Override
	public User getUserByUname(String username) {
		User u = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS where USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setUserId(rs.getInt("USER_ID"));
				u.setFirstname(rs.getString("FIRSTNAME"));
				u.setLastname(rs.getString("LASTNAME"));
				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("PASS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		User u = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setUserId(rs.getInt("USER_ID"));
				u.setFirstname(rs.getString("FIRSTNAME"));
				u.setLastname(rs.getString("LASTNAME"));
				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("PASS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from USERS";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				User temp = new User(
						rs.getInt("USER_ID"), 
						rs.getString("FIRSTNAME"), 
						rs.getString("LASTNAME"), 
						rs.getString("USERNAME"), 
						rs.getString("PASS"));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@Override
	public User updateFirstname(String newVal, int id) { 
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update USERS set FIRSTNAME = ? where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newVal);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return getUserById(id);
	}
	
	@Override
	public User updateLastname(String newVal, int id) { 
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update USERS set LASTNAME = ? where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newVal);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return getUserById(id);
	}

	@Override
	public User updateUsername(String newVal, int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update USERS set USERNAME = ? where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newVal);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return getUserById(id);
	}

	@Override
	public User updatePassword(String newVal, int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update USERS set PASS = ? where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newVal);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return getUserById(id);
	}

	@Override
	public Account getAccount(int id) {
		Account acc = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ACCOUNTS where ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				acc.setAccountId(rs.getInt("ACC_ID"));
				acc.setAccountType(Account.accountTypeFromStr(rs.getString("ACC_TYPE")));
				acc.setUserId(rs.getInt("USER_ID"));
				acc.setBalance(rs.getDouble("BALANCE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ACCOUNTS";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				Account temp = new Account(
						rs.getInt("ACC_ID"),
						Account.accountTypeFromStr(rs.getString("ACC_TYPE")),
						rs.getInt("USER_ID"),
						rs.getDouble("BALANCE")
						);
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public ArrayList<Account> getUserAccounts(User u) {
		ArrayList<Account> accounts = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ACCOUNTS where USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Account temp = new Account(
						rs.getInt("ACC_ID"),
						Account.accountTypeFromStr(rs.getString("ACC_TYPE")),
						rs.getInt("USER_ID"),
						rs.getDouble("BALANCE")
						);
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public User addUser(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into users (firstname, lastname, username, pass)\r\n" + 
					"values (?, ?, ?, ?)";
			String[] keys = new String[]{"USER_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());

			
			int row = ps.executeUpdate();
			if (row != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					u.setUserId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Account addAccount(Account acc) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ACCOUNTS (ACC_TYPE, USER_ID, BALANCE) " +
					"values (?,?,?)";
			String[] keys = {"ACC_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, Account.accountTypeFromEnum(acc.getAccountType()));
			ps.setInt(2, acc.getUserId());
			ps.setDouble(3, acc.getBalance());
			
			int row = ps.executeUpdate();
			if (row != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					acc.setAccountId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public Account updateAccountBalance(double bal, int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update ACCOUNTS set BALANCE = ? where ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, bal);
			ps.setInt(2, id);
			
			int rows = ps.executeUpdate();
			if (rows == 0) 
				return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAccount(id);
	}
	
}
