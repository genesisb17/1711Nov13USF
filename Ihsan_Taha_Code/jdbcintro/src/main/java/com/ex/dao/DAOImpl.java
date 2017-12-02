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

public class DAOImpl implements DAO
{

	public ArrayList<Artist> getArtists()
	{
		ArrayList<Artist> artists = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "SELECT * FROM ARTIST";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
			{
				Artist temp = new Artist();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return artists;
	}

	@Override
	public Artist getArtistById(int id)
	{

		Artist art = new Artist();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "SELECT * FROM ARTIST WHERE ARTISTID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			while (info.next())
			{
				art.setId(info.getInt(1));
				art.setName(info.getString(2));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return art;
	}

	@Override
	public Artist addArtist(String name)
	{

		Artist art = new Artist();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ARTIST (NAME) VALUES (?)";
			String[] key = new String[1];
			key[0] = "ARTISTID";

			PreparedStatement ps = conn.prepareStatement(sql, key);

			ps.setString(1, name);
			int rows = ps.executeUpdate();
			// int id = 0;
			if (rows != 0)
			{
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next())
				{
					art.setId(pk.getInt(1));
				}
				art.setName(name);
				conn.commit();
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return art;
	}

	@Override
	public Artist updateArtist(int id, String name)
	{
		Artist art = new Artist();

		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "UPDATE ARTIST SET NAME = ? where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			art.setId(id);
			art.setName(name);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return art;
	}

	@Override
	public Artist getNameById(int id)
	{
		Artist artist = new Artist();

		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "{? = call get_artist_by_id(?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();

			artist.setName(cs.getString(1));
			artist.setId(id);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public List<Artist> getArtistsStoredProc()
	{
		List<Artist> artists = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();)
		{
			String sql = "Call get_all_artists(?)";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);

			int numRows = cs.executeUpdate();
			System.out.println(numRows + " rows affected");
			;

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next())
			{
				artists.add(new Artist(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return artists;
	}
}
