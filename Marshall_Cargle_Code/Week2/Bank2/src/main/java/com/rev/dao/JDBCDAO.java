package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.rev.pojos.Account;
import com.rev.pojos.User;

import com.rev.util.ConnectionFactory;

public class JDBCDAO implements DAO {

	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql="insert into Users (FIRSTNAME, LASTNAME, USERNAME, PASSWORD)"
					+ " values ((?), (?), (?), (?))";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.executeUpdate();
			conn.commit();
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Sorry but an account with this username already exists");
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		User user=getUser(u.getEmail(), u.getPassword());
		addAccount(user);
		return user;
	}
	
	public User getUser(String email, String password) {
		User user=null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Users where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				user.setId(info.getInt(1));
				user.setFirstname(info.getString(2));
				user.setLastname(info.getString(3));
				user.setEmail(info.getString(4));
				user.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Account addAccount(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql="insert into Accounts (user_id, balance) values ((?), (?))";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setDouble(2, 0);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccount(int U_id) {
		Account a=new Account();	
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Accounts where User_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, U_id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				a.setId(info.getInt(1));
				a.setU_id(info.getInt(2));
				a.setBalance(info.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Double setBalance(int id, double money) {
		Account a=new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql="Update Accounts set balance = ? where Acc_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, money);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}
}
