package com.ex.dao;

import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Artist;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class DAOimp implements DAO {

	@Override
	public ArrayList<Artist> getArtists() {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
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
		Artist art = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from artist where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
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

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "insert into artist (Name) values (?)";
			String[] key = new String[1];
			key[0] = "artistid";

			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setString(1, name);
			ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			while (pk.next()) {
				art.setId(pk.getInt(1));
			}
			art.setName(name);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist updateArtist(int id, String name) {
		Artist art = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "UPDATE ARTIST SET NAME = ? WHERE ARTISTID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			art = this.getArtistById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;

	}

	@Override
	public Artist getNameById(int id) {
		Artist art = new  Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "{ ? = call get_artist_by_id (?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			art.setId(id);
			art.setName(cs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public List<Artist> getArtistByStoredProcedure() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artists;
	}

}
