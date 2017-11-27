package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pjos.Artist;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO{

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
	public Artist getArtistsById(int id) {
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "select * from artist where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			String sql = "insert into artist (Name) values (?)";
			String[] key = new String[1];
			key[0] = "artistid";
			
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, name);
			int rows = ps.executeUpdate();
			//int id = 0;
			if(rows != 0) {
			
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
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
	public Artist updateById(int id,String name) {
		
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			String sql = "update artist set name=(?) where artistid =(?)";
			int ret = 0;
			//String[] key = new String[2];
			//key[0] = "artistid";
			//key[1] = "name";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2,name);
			ps.setInt(1, id);
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return getArtistsById(id);
	}

}
