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

import oracle.jdbc.OracleTypes;

public class DAOImpl implements DAO{
	@Override
	public List<Artist> getArtistsStoredProc() {
		List<Artist> artists = new ArrayList<>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "{call get_all_artists(?)}";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			int numRows = cs.executeUpdate();
			System.out.println(numRows + " rows affected");
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
				artists.add(new Artist(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artists;
	}
	@Override
	public Artist getNameById(int id) {
		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			//Curly breackets are syntax
			//			   out							in
			String sql = "{? = call get_artist_by_id(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			artist.setName(cs.getString(1));
			artist.setId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artist;
	
	}
	@Override
	public ArrayList<Artist> getArtists() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Artist tmp = new Artist();
				tmp.setId(rs.getInt(1));
				tmp.setName(rs.getString(2));
				artists.add(tmp);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return artists;
	}

	@Override
	public Artist getArtistById(int id) {
		Artist art = new Artist();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//index starts at 1 for this type of call
			String sql = "select * from artist where artistid = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				art.setId(info.getInt(1));
				art.setName(info.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return art;
	}
	
	

	//we can either take in the individual parameters
	//or we could just take in the artist w/o the id
	@Override
	public Artist addArtist(String name) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			//sql command example 
			//insert into artist (name) values ('Beyonce');
			String sql = "insert into artist (Name) values (?)";
			String[] key= new String[1];
			key[0] = "artistid";
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, name);
			int rows = ps.executeUpdate();
			//int id = 0;
			
			if(rows !=0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
				//	id = pk.getInt(1);
					art.setId(pk.getInt(1));
				}
				art.setName(name);
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist updateById(int id, String name) {
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "update ARTIST set (NAME) = (?) where artistid = (?)";
			/*String[] skey = new String[2];
			skey[0] = "artistid";
			skey[1] = "name";
			*///for returning stuff
			PreparedStatement ps = conn.prepareStatement(sql);//, skey);
			
			ps.setString(1, name);
			ps.setInt(2, id);
			int rows = ps.executeUpdate();
			if (rows > 0){
				art.setName(name);
				art.setId(id);
				conn.commit();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

}
