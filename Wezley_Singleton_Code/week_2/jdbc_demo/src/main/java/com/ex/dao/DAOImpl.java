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

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class DAOImpl implements DAO {

	@Override
	public ArrayList<Artist> getAllArtists() {
		
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// The SQL statement that executes
			String sql = "SELECT * FROM artist";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Artist temp = new Artist();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);
				
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				art.setId(rs.getInt(1));
				art.setName(rs.getString(2));
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return art;
	}

	@Override
	public Artist addArtist(String name) {
		
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// prevents the transaction from being committed to the DB before we verify that it was successful
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			String[] key = new String[1];
			key[0] = "artistid";
			
			// 
			PreparedStatement pstmt = conn.prepareStatement(sql, key);
			pstmt.setString(1, name);
			
			// returns the number of rows updated
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
 				
				while(rs.next()) {
					art.setId(rs.getInt(1));
				}
				
				art.setName(name);
				conn.commit();
				
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist updateArtist(int id, String newName) {
		
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setInt(2, id);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				art = getArtistById(id);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return art;
	}

	@Override
	public List<Artist> getAllArtistsStoredProc() {
		
		List<Artist> artists = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// build our SQL string that will call the stored procedure, get_all_artists
			String sql = "{call get_all_artists(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			// registered the out parameter as a cursor type
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			int rowsUpdated = cs.executeUpdate();
			System.out.println(rowsUpdated + " rows updated");
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				artists.add(new Artist(rs.getInt(1), rs.getString(2)));
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return artists;
	}

	@Override
	public Artist getNameById(int id) {
		
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// first '?' is the out parameter of the stored procedure, the second '?' is the argument
			String sql = "? = call get_artist_by_id(?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			// defines the index of the '?' and the type it is expected to hold
			cs.registerOutParameter(1, Types.VARCHAR);
			
			// similar syntax to PreparedStatement...
			cs.setInt(2, id);
			
			// executes the callable statement
			cs.execute();
			
			// retrieves the out parameter
			artist.setName(cs.getString(1));
			artist.setId(id);
			
			
			
			
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return artist;
	}

}
