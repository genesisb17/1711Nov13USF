package com.rev.dao;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDao implements DAO 
{
	@Override
	public void connect() 
	{
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE)Values('payback')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			conn.commit();
			conn.close();
			System.out.println("Executed");
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}
	
}