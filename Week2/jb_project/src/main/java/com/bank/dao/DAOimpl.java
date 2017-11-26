package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.jdbc.ConnectionFactory;
import com.bank.main.MainDriver;
import com.bank.pojos.Users;

public class DAOimpl implements DAO{
	@Override
	public Users addUser(ArrayList<String> input) {
		// TODO Auto-generated method stub
		Users u = new Users(input.get(0), input.get(1), input.get(2).toLowerCase(), input.get(3));
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
		try{
			System.out.println(u.toFile());
		} catch(NullPointerException e) {
			return u;
		}
		
		System.out.println("Congratulations. Successfully created a new user.");
		return u;
	}

	@Override
	public Users logOn(String un, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
