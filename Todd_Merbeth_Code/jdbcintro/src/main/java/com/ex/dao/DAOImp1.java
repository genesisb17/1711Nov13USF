package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojo.Artist;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class DAOImp1 implements DAO {

	@Override
	public ArrayList<Artist> getArtists() {

		ArrayList<Artist> artists = new ArrayList<Artist>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Artist temp = new Artist();
				temp.setId(rs.getInt(1)); // Index starts at 1
				temp.setName(rs.getString(2));
				artists.add(temp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return artists;
	}

	@Override
	public Artist getArtistsById(int id) {
		Artist art = new Artist();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from artist where artistid = ?"; // The ? can be set for prepared statements,
			PreparedStatement ps = conn.prepareStatement(sql); // in normal statements would have to do "" + something
																// which is dangerous
			ps.setInt(1, id); // This is where you set the ? to the value you give it
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				art.setId(info.getInt(1));
				art.setName(info.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return art;
	}

	@Override
	public Artist addArtist(String name) {
		Artist art = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false to make sure it has properly changed
			String sql = "insert into artist (Name) values (?)"; // JDBC can handle the "" for you
			String[] key = new String[1];
			key[0] = "artistid";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, name);
			int rows = ps.executeUpdate(); // could set variable to track that the update happened
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					art.setId(pk.getInt(1));
				}
				art.setName(name);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist updateArtist(int id, String name) {
		Artist art = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false); // Set to false if want to make sure it has properly changed something before commit
			String sql = "update artist set name = ? where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name); // First number is which ?, 2nd is value passed
			ps.setInt(2, id);

			int rows = ps.executeUpdate();
			// ps.executeUpdate();
			if (rows != 0) {
				art.setId(id);
				art.setName(name);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return art;
	}
	
	@Override
	public Artist getNameById(int id) {
		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{ ? = call get_artist_by_id(?)}"; // First is return 
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			artist.setName(cs.getString(1));
			artist.setId(id);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}
	
	@Override
	public List<Artist> getArtistsStoredProc(){
		List<Artist> artists = new ArrayList<>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection()){
			String sql = "{call get_all_artists(?)}";
			
			CallableStatement cs = connect.prepareCall(sql);
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
