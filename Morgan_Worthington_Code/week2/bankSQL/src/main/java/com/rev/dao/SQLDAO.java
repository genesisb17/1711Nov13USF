package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class SQLDAO implements DAO {

	@Override
	public double updateBalance(double amountChange, Account acc) {

		double current=acc.getBalance();
		int id=acc.getAccountId();
		double after=current+amountChange;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()) {
			String sql="UPDATE ACCOUNTS SET BALANCE=? WHERE ACC_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, after);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return after;
	}

	@Override
	public void addNewUser(String first, String last, String user, String pass) {
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO USERS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD) VALUES (?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, user);
			ps.setString(4, pass);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNewAccount(int userId, double balance) {
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			String sql = "INSERT INTO ACCOUNTS(USER_ID,BALANCE) VALUES (?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDouble(2, balance);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(int id) {
		User u=new User();
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			String sql="SELECT * FROM USERS WHERE U_ID = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
				ArrayList<Account> accounts=getAccountsByUser(u.getId(),conn);
				u.setAccounts(accounts);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;		
	}

	@Override
	public Account getAccountById(int id) {
		Account acc=new Account();
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String sql="SELECT * FROM ACCOUNTS WHERE ACC_ID = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				acc.setAccountId(rs.getInt(1));
				acc.setUserId(rs.getInt(2));
				acc.setBalance(rs.getDouble(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public User getUserByUsername(String username) {
		User u=new User();
		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			String sql="SELECT * FROM USERS WHERE USERNAME = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
				ArrayList<Account> accounts=getAccountsByUser(u.getId(),conn);
				u.setAccounts(accounts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;		
	}

	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users=new ArrayList<>();

		try(Connection conn=ConnectionFactory.getInstance().getConnection();){
			String sql="SELECT * FROM USERS";
			PreparedStatement statement=conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				User temp= new User();
				temp.setId(rs.getInt(1));
				temp.setFirstname(rs.getString(2));
				temp.setLastname(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setPassword(rs.getString(5));
				ArrayList<Account> accounts=getAccountsByUser(temp.getId(),conn);
				temp.setAccounts(accounts);
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}


	@Override
	public ArrayList<Account> getAccountsByUser(int userId, Connection c) {

		ArrayList<Account> accounts=new ArrayList<>();
		try {
			String userAccounts="SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
			PreparedStatement acc = c.prepareStatement(userAccounts);
			acc.setInt(1, userId);
			ResultSet accList = acc.executeQuery();

			while(accList.next()) {
				Account tempAcc=new Account();
				tempAcc.setAccountId(accList.getInt(1));
				tempAcc.setUserId(accList.getInt(2));
				tempAcc.setBalance(accList.getDouble(3));
				accounts.add(tempAcc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}


}

