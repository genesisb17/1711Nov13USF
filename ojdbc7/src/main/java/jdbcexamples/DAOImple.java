package jdbcexamples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

public class DAOImple implements DAO
{

	@Override
	public ArrayList<Artist> getArtists() 
	{
		// TODO Auto-generated method stub
		ArrayList<Artist> artists  = new ArrayList<Artist>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql ="select * from artist";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				Artist temp = new Artist();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				artists.add(temp);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artists;
	}
	
	@Override
	public Artist getArtbyid(int id) 
	{
		// TODO Auto-generated method stub
		Artist art = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "select * from artist where ARTISTID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); //sets info
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				art.setId(info.getInt(1));
				art.setName(info.getString(2));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return art;
	}

	@Override
	public Artist addArtist(String name) 
	{
		Artist art = new Artist();	
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "insert into artist(name) values(?)";
			String[] key = new String[1];
			key[0]="artistid";
			
			PreparedStatement ps = conn.prepareStatement(sql,key);
			ps.setString(1, name);
			int rows = ps.executeUpdate();
			int id = 0;
			ResultSet pk = ps.getGeneratedKeys();
			
			if(rows!=0) {
			while(pk.next())
			{
				art.setId(pk.getInt(1));
			}
			art.setName(name);
			conn.commit();
			}
			//update - inserting data, querying- getting data
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}

	@Override
	public Artist UpdateArtist(String name, int name2) 
	{
		Artist art = new Artist();	
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			conn.setAutoCommit(false);
			String sql = "update artist set name=? where ARTISTID =?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, name2);
			ps.executeUpdate();
			art.setName(name);
			art.setId(0);
			conn.commit();
			conn.close();
			//update - inserting data, querying- getting data
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
		// TODO Auto-generated method stub

	}

	@Override
	public Artist updateArtist(int id, String name) {
		// TODO Auto-generated method stub
		Artist art = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "update artist set name = ? where artistid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			art = getArtbyid(id);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return art;
	}
	public Artist getNameByID(int id)
	{
		Artist artist = new Artist();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String sql = "{? = call get_artist_by_id(?))";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1,Types.VARCHAR);
			cs.setInt(2, id);
			cs.execute();
			artist.setName(cs.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artist;
	}
	
	public List<Artist>getArtistsStoredProc()
	{
		List<Artist> artists = new ArrayList<>();
		try(Connection connect = ConnectionFactory.getInstance().getConnection())
		{
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