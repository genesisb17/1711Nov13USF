package com.rev.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.util.ConnectionFactory;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class DAOImpl implements DAO{

	public List<User> getUsers() {
		List<User> usersList = new ArrayList<User> ();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS";
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				usersList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public List<Account> getAccounts() {
		List<Account> accountsList = new ArrayList<Account>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ACCOUNTS";
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setBalance(rs.getBigDecimal(3));
				accountsList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsList;
	}
	
	public List<Account> getUserAccounts(User u) {
		List<Account> accountsList = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				Account temp = new Account();
				temp.setAccountId(info.getInt(1));
				temp.setUserId(info.getInt(2));
				temp.setBalance(info.getBigDecimal(3));
				accountsList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsList;
	}

	public User getUser(int id) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS WHERE U_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				user.setId(info.getInt(1));
				user.setFirstName(info.getString(2));
				user.setLastName(info.getString(3));
				user.setUsername(info.getString(4));
				user.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// If user Id is default (i.e. user not found in database) return null user
		if (user.getId() == 0)
			user = null;
		
		return user;
	}

	public User getUser(String username) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				user.setId(info.getInt(1));
				user.setFirstName(info.getString(2));
				user.setLastName(info.getString(3));
				user.setUsername(info.getString(4));
				user.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// If user Id is default (i.e. user not found in database) return null user
		if (user.getId() ==0 )
			user = null;
		
		return user;
	}
	
	public Account getAccount(int id) {
		Account account = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ACCOUNTS WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				account.setAccountId(info.getInt(1));
				account.setUserId(info.getInt(2));
				account.setBalance(info.getBigDecimal(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}

	public User addUser(User u) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "U_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			
			while (pk.next()) u.setId(pk.getInt(1));
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	public Account addAccount(Account a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] key = new String[1];
			key[0] = "ACC_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, a.getUserId());
			ps.setBigDecimal(2, a.getBalance());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			
			while (pk.next()) a.setAccountId(pk.getInt(1));
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	public Account deposit(Account a, BigDecimal deposit) {
		
		BigDecimal updatedBalance = a.getBalance().add(deposit);
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, updatedBalance);
			ps.setInt(2, a.getAccountId());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				a.setBalance(updatedBalance);
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Account withdraw(Account a, BigDecimal withdrawal) {
		BigDecimal updatedBalance = a.getBalance().subtract(withdrawal);
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACC_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, updatedBalance);
			ps.setInt(2, a.getAccountId());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				a.setBalance(updatedBalance);
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
