package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO{

	@Override
	public ArrayList<Artist> getArtists() {
		
		ArrayList<Artist> artists = new ArrayList<Artist>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
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
	public Artist getArtistbyId(int id) {
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from artist WHERE artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//index going by number of ?s
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				art.setId(info.getInt(1));
				art.setName(info.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist addArtist(String name) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into artist (Name) values (?)";
			String[] key = new String[1];
			key[0] = "artistid";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, name);
			int rows = ps.executeUpdate();
			if(rows!=0) {
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				art.setId(pk.getInt(1));
			}
			art.setName(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}
	
	@Override
	public Artist updateArtist(int id, String name) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//conn.setAutoCommit(false);
			String sql = "UPDATE artist SET name = ? WHERE ARTISTID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			art = getArtistbyId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

}
