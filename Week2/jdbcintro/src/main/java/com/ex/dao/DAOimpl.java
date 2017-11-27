package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.ex.pojos.Artist;

import jdbcintro.ConnectionFactory;

public class DAOimpl implements DAO {

	@Override
	public ArrayList<Artist> getArtists() {
		// TODO Auto-generated method stub
		
		ArrayList<Artist> artists = new ArrayList<>();
		
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from artist";
			
			Statement ps = con.createStatement();
			
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		// TODO Auto-generated method stub
		Artist artiste = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from artist where artistid = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			
			while(info.next()) {
				
				artiste.setId(info.getInt(1));
				artiste.setName(info.getString(2));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artiste;
	}

	@Override
	public Artist addArtist(String name) {
		// TODO Auto-generated method stub
		Artist art = new Artist();		
		try(Connection coon = ConnectionFactory.getInstance().getConnection()){
			coon.setAutoCommit(false);

			String sql = "insert into artist (Name) values (?)";
			String[] key = new String[1];
			key[0] = "artistid";
			
			PreparedStatement ps = coon.prepareStatement(sql, key);
			
			ps.setString(1, name);
			ps.executeUpdate();
			int id = 0;
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
			art.setId(rs.getInt(1));
			}
			art.setName(name);
			coon.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist updateArtist(int id, String name) {
		// TODO Auto-generated method stub
		Artist arg = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			//NAME = 1, ID = 2!!!!!!!!!
			String sql = "update artist set (Name) = (?) where (ArtistId) = (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ORDER OF PARAMETERS IN THE QUERY!!!!!!!
			ps.setInt(2, id);
			ps.setString(1, name);
			ps.executeUpdate();
			conn.commit();
			arg = getArtistById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arg;
	}

	@Override
	public Artist getNameById(int id) {
		// TODO Auto-generated method stub
		Artist artist = new Artist();
		try(Connection con = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "{ ? = call get_artist_by_id(?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			artist.setName(cs.getString(1));
			artist.setId(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
