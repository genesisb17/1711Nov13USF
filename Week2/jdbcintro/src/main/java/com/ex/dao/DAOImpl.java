package com.ex.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

public class DAOImpl implements DAO{

	@Override
	public ArrayList<Artist> getArtists() {
		ArrayList<Artist> artists = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				Artist temp = new Artist();
				temp.setId(rs.getInt("ARTISTID"));
				temp.setName(rs.getString(2));
				artists.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}

}
