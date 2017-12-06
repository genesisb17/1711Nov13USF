package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;
import com.rev.pojos.ReimbursementType;
import com.rev.pojos.UserRole;
import com.rev.util.ConnectionFactory;

public class DAOimp implements DAO {

	public ERSUser getUserByID(int userID) {
		ERSUser usr = new ERSUser();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USERS where ERS_USER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUserid(info.getInt(1));
				usr.setUsername(info.getString(2));
				usr.setPassword(info.getString(3));
				usr.setFirstName(info.getString(4));
				usr.setLastName(info.getString(5));
				usr.setEmail(info.getString(6));
				usr.setRoleID(info.getInt(7));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	public ArrayList<ERSUser> getUsers() {
		ArrayList<ERSUser> users = new ArrayList<ERSUser>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from ERS_USER";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				ERSUser temp = new ERSUser();
				temp.setUserid(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRoleID(rs.getInt(7));
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public Reimbursement getReimbursementByID(int rID) {
		Reimbursement r = new Reimbursement();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_REIMBURSEMENT where REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r.setReimbID(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getDouble(3));
				r.setResolved(rs.getDouble(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getString(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusID(rs.getInt(9));
				r.setTypeID(rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	public ArrayList<Reimbursement> getReimbursements() {
		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from ERS_REIMBURSEMENT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbID(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getDouble(3));
				temp.setResolved(rs.getDouble(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getString(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusID(rs.getInt(9));
				temp.setTypeID(rs.getInt(10));
				reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;
	}

	public ReimbursementStatus getStatusByID(int statusID) {
		ReimbursementStatus status = new ReimbursementStatus();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_REIMBURSEMENT_STATUS where REIMBURSEMENT_STATUS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusID);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				status.setStatusID(info.getInt(1));
				status.setStatus(info.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public ReimbursementType getTypeByID(int typeID) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserRole getRoleByID(int roleID) {
		UserRole role = new UserRole();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USER_ROLES where ERS_USER_ROLE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleID);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				role.setRoleID(info.getInt(1));
				role.setUser(info.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return role;
	}

	public ERSUser addUser(ERSUser ersUser) {
		ERSUser usr = new ERSUser();		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, "
					+ "USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)";
			String[] key = new String[1];
			key[0] = "U_ID";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, usr.getUsername());
			ps.setString(2, usr.getPassword());
			ps.setString(3, usr.getFirstName());
			ps.setString(4, usr.getLastName());
			ps.setString(5, usr.getEmail());
			ps.setInt(6, usr.getRoleID());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				usr.setUserid(pk.getInt(1));
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}

	public Reimbursement addReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	public ERSUser getERSUserByUsername(String username) {
		ERSUser usr = new ERSUser();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USERS where ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUserid(info.getInt(1));
				usr.setUsername(info.getString(2));
				usr.setPassword(info.getString(3));
				usr.setFirstName(info.getString(4));
				usr.setLastName(info.getString(5));
				usr.setEmail(info.getString(6));
				usr.setRoleID(info.getInt(7));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	public ERSUser getERSUserByUsernameAndPassword(String username, String password) {
		ERSUser usr = new ERSUser();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from ERS_USERS where ERS_USERNAME = ? AND ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				usr.setUserid(info.getInt(1));
				usr.setUsername(info.getString(2));
				usr.setPassword(info.getString(3));
				usr.setFirstName(info.getString(4));
				usr.setLastName(info.getString(5));
				usr.setEmail(info.getString(6));
				usr.setRoleID(info.getInt(7));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	/*
	 * @Override public ArrayList<Artist> getArtists() {
	 * 
	 * ArrayList<Artist> artists = new ArrayList<>();
	 * 
	 * try(Connection conn = ConnectionFactory.getInstance().getConnection();){
	 * String sql = "select * from artist"; Statement statement =
	 * conn.createStatement(); ResultSet rs = statement.executeQuery(sql);
	 * 
	 * while(rs.next()){ Artist temp = new Artist();
	 * temp.setId(rs.getInt("ARTISTID")); temp.setName(rs.getString(2));
	 * artists.add(temp); } } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return artists; }
	 * 
	 * @Override public Artist getArtistById(int id) { Artist art = new Artist();
	 * 
	 * try(Connection conn = ConnectionFactory.getInstance().getConnection()){
	 * String sql = "select * from artist where artistid = ?"; PreparedStatement ps
	 * = conn.prepareStatement(sql); ps.setInt(1, id); ResultSet info =
	 * ps.executeQuery();
	 * 
	 * while(info.next()){ art.setId(info.getInt(1));
	 * art.setName(info.getString(2)); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return art; }
	 * 
	 * @Override public Artist addArtist(String name) {
	 * 
	 * Artist art = new Artist(); try(Connection conn =
	 * ConnectionFactory.getInstance().getConnection()){ conn.setAutoCommit(false);
	 * String sql = "insert into artist (Name) values (?)"; String[] key = new
	 * String[1]; key[0] = "artistid";
	 * 
	 * PreparedStatement ps = conn.prepareStatement(sql, key); ps.setString(1,
	 * name); int rows = ps.executeUpdate(); if(rows!=0){
	 * 
	 * ResultSet pk = ps.getGeneratedKeys(); while(pk.next()){
	 * art.setId(pk.getInt(1)); } art.setName(name); conn.commit(); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return art; }
	 * 
	 * @Override public void updateArtist(int id, String name) { try(Connection conn
	 * = ConnectionFactory.getInstance().getConnection();){
	 * conn.setAutoCommit(false); String sql =
	 * "update artist set name = ? where artistid = ?"; PreparedStatement ps =
	 * conn.prepareStatement(sql); ps.setString(1, name); ps.setInt(2, id);
	 * ps.executeUpdate(); //System.out.println(rows); conn.commit(); // art =
	 * getArtistById(id); } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

}
