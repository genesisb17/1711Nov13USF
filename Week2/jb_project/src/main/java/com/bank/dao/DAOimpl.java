package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.jdbc.ConnectionFactory;
import com.bank.main.MainDriver;
import com.bank.pojos.Accounts;
import com.bank.pojos.Users;

public class DAOimpl implements DAO{
	@Override
	public Users addUser(ArrayList<String> input) {
		// TODO Auto-generated method stub
		Users u = new Users(input.get(0), input.get(1), input.get(2).toLowerCase(), input.get(3));
		Accounts a = new Accounts();
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			con.setAutoCommit(false);
			String sql = "INSERT INTO Users (FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES (?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "U_ID";
			PreparedStatement ps = con.prepareStatement(sql, key);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
			u.setId(rs.getInt(1));
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Username must be unique.\n"
					+ "Try again.");
			u = null;
			MainDriver.run();

		}
		//setting the initial balance
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//setting account table user id to user table user id
			a.setuId(u.getId());
			conn.setAutoCommit(false);
			String sql2 = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] a_key = new String[1];
			a_key[0] = "ACC_ID";
//			System.out.println("A " + a.getuId());
//			System.out.println("U " + u.getId());
			PreparedStatement ps2 = conn.prepareStatement(sql2, a_key);
			ps2.setInt(1, a.getuId());
			ps2.setDouble(2, 0.0);
			ps2.executeUpdate();
			ResultSet rs2 = ps2.getGeneratedKeys();
			while(rs2.next()) {
			a.setAcctId(rs2.getInt(1));
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Congratulations. Successfully created a new user.");
		return u;
	}

	@Override
	public Integer logOn(String un, String pwd) {
		// TODO Auto-generated method stub
		Users u = new Users();
		try(Connection con = ConnectionFactory.getInstance().getConnection()) {
			//con.setAutoCommit(false);
			String sql = "SELECT * FROM USERS WHERE USERNAME = (?) AND PASSWORD = (?)";
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, un);
			prep.setString(2, pwd);
			
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
			}

			//con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u.getId();
		
	}


	@Override
	public Accounts addAccount(Integer uid) {
		// TODO Auto-generated method stub
		Accounts a = new Accounts();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql2 = "INSERT INTO ACCOUNTS (USER_ID, BALANCE) VALUES (?, ?)";
			String[] a_key = new String[1];
			a_key[0] = "ACC_ID";
			PreparedStatement ps2 = conn.prepareStatement(sql2, a_key);
			ps2.setInt(1, uid);
			ps2.setDouble(2, 0.0);
			ps2.executeUpdate();
			ResultSet rs2 = ps2.getGeneratedKeys();
			while(rs2.next()) {
			a.setAcctId(rs2.getInt(1));
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
