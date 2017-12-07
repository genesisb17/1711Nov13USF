package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rev.pojo.R;
import com.rev.pojo.User;
import java.util.Date;
public class FileDao implements DAO 
{
	@Override
	public void addRtype(String s) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE)Values(?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public void adders_user_roles(String s) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ers_user_roles(USER_ROLE)VALUES(?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void addRStatus(String s) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into ERSREIMBURSEMENTSTATUS(REIMB_STATUS)Values(?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ps.executeUpdate();
			conn.commit();
			conn.close();
			System.out.println("Executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void adders_users(String user, String pass, String first, String last, String email, int i) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "insert into ers_users(PASSWORD , LASTNAME , FIRSTNAME , EMAIL , USERNAME,ERS_USER_ROLE_ID)Values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, last);
			ps.setString(3, first);
			ps.setString(4, email);
			ps.setString(5, user);
			ps.setInt(6, i);
			ps.executeUpdate();
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) 
		{

			// TODO Auto-generated catch block
		}
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<R> getReimbursements(String username, String password) {
		// TODO Auto-generated method stub

		ArrayList<R> a = new ArrayList<R>();
		System.out.println("test");
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			User u = new User();
			R r = new R();
			u = geters_users(username, password);

			String sql = "select * FROM ERS_REIMBURSEMENT WHERE U_ID=?";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, u.getUid());
			ResultSet info1 = p.executeQuery();
			while (info1.next()) 
			{
				
				r.setReimb_Amount(info1.getDouble("REIMB_AMOUNT"));
				r.setSubmit(info1.getString("REIMB_SUBMITTED"));
				r.setResolv(info1.getString("REIMB_RESOLVED"));
				r.setDescription(info1.getString("REIMB_DESCRIPTION"));
				r.setU_ID(info1.getInt("U_ID"));
				r.setREIMB_STATUS_ID(info1.getInt("REIMB_STATUS_ID"));
				r.setREIMB_TYPE_ID(info1.getInt("REIMB_TYPE_ID"));
				r.setERS_USER_ROLE_ID(info1.getInt("U_ID2"));
				r.setReimb_id(info1.getInt("REIMB_TYPE_ID"));
				a.add(r);
			}
			conn.commit();
			conn.close();
			System.out.println(a.size());
			System.out.println("executed");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("what");
		}
		return a;
	}

	@Override
	public String getRtype(int i) 
	{

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select REIMB_TYPE from ERS_REIMBURSEMENT_TYPE where REIMB_TYPE_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) 
			{
				return info.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public int findmax() 
	{

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			String sql = "select max(REIMB_STATUS_ID) from ERSREIMBURSEMENTSTATUS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			while (info.next()) 
			{
				return info.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getRtypeById(String i) 
	{

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			String sql = "select REIMB_TYPE_ID from ERS_REIMBURSEMENT_TYPE where  REIMB_TYPE=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) 
			{
				return info.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public String getRStatus(int i) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select REIMB_STATUS from ERSREIMBURSEMENTSTATUS where REIMB_STATUS_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				return info.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
	}
	
	@Override
	public int getRStatusById(String i) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select REIMB_STATUS_ID from ERSREIMBURSEMENTSTATUS where  REIMB_STATUS=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				return info.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		// TODO Auto-generated method stub
	}
	
	@Override
	public User geters_users(String user, String pass) 
	{
		// TODO Auto-generated method stub
		
		User u = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);

			String sql = "select * from ers_users where USERNAME =? and PASSWORD =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet info = ps.executeQuery();			
			while(info.next())
			{
				u.setUsername(info.getString("USERNAME"));
				u.setEmail(info.getString("EMAIL"));
				u.setFirstname(info.getString("FIRSTNAME"));
				u.setLastname(info.getString("LASTNAME"));
				u.setPassword(info.getString("PASSWORD"));
				u.setUid(info.getInt("U_ID"));
				u.setUser_Role_Id(info.getInt("ERS_USER_ROLE_ID"));
				return u;
			}
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;


		//
	}

	// QC
	@Override
	public String geters_user_roles(int i) 
	{
		// TODO Auto-generated method stub

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_user_roles where ERS_USER_ROLE_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				return info.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//might not work with this
	@Override
	public int geters_user_rolesbyId(String role) 
	{
	// TODO Auto-generated method stub

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_user_roles where USER_ROLE =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, role);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				return info.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addReimbursements(double amount, String description, int uid, int statusid, int typeid,int uid2) 
	{
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			// add submit date and approved date to it.
			conn.setAutoCommit(false);
			//String sql = "insert into ERS_REIMBURSEMENT(REIMB_AMOUNT,REIMB_DESCRIPTION,U_ID,REIMB_STATUS_ID,REIMB_TYPE_ID,U_ID2)values (?,?,?,?,?,?)";
			String sql = "insert into ERS_REIMBURSEMENT(REIMB_AMOUNT,REIMB_DESCRIPTION,U_ID,REIMB_STATUS_ID,REIMB_TYPE_ID,U_ID2,REIMB_SUBMITTED)Values(?,?,?,?,?,?,to_date(sysdate,'DD/MM/YYYY'))";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setInt(3, uid);
			ps.setInt(4, statusid);
			ps.setInt(5, typeid);
			ps.setInt(6, uid2);
			ps.executeUpdate();
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Failed to save reimbursement");
		}
	}
	@Override
	public void UpdateStatus(int id)
	{
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			// add submit date and approved date to it.
			conn.setAutoCommit(false);
			String sql = "update ERSREIMBURSEMENTSTATUS set REIMB_STATUS = ? where REIMB_STATUS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "success");
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Failed to save reimbursement");
		}
	}
	
	@Override
	public void UpdateReimb(int reimbid1,int uid2)
	{
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			// add submit date and approved date to it.
			conn.setAutoCommit(false);
			String sql = "update ERS_REIMBURSEMENT set U_ID2=? where reimb_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid2);
			ps.setInt(2, reimbid1);
			ps.executeUpdate();
			conn.commit();
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Failed to save reimbursement");
		}
	}
}