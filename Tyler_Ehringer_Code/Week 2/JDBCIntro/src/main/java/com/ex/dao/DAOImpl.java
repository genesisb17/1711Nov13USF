package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class DAOImpl implements DAO{

	@Override
	public Artist getArtist(int artistId) {
		Artist a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from artist where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artistId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Artist(rs.getInt("ARTISTID"), rs.getString("NAME"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Artist addArtist(String name) {
		Artist a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String insert = "insert into artist (name) values (?)";
			String[] key = new String[2];
			key[0] = "artistid";
			key[1] = "name";
			PreparedStatement ps = conn.prepareStatement(insert, key);
			ps.setString(1, name);
			int rows = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				a = new Artist(pk.getInt(1), pk.getString(2));
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public ArrayList<Artist> getArtists() {
		ArrayList<Artist> artists = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from artist";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				artists.add(new Artist(rs.getInt("ARTISTID"), rs.getString("NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}

	@Override
	public Artist updateArtist(int artistid, String name) {
		Artist a = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String update = "update artist set name = ? where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, name);
			ps.setInt(2, artistid);
			if(ps.executeUpdate() > 0) a = getArtist(artistid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Artist getNameById(int id) {
		Artist a = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call get_name_by_id(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(1, id);
			cs.executeUpdate();
			a.setName(cs.getString(2));
			a.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Artist> getArtistsStoredProc() {
		List<Artist> artists = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call get_all_artists(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			int numRows = cs.executeUpdate();
			System.out.println(numRows + " rows affected");
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				artists.add(new Artist(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}
	
	

}
