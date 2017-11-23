package jdbcexamples;

import java.util.ArrayList;
import jdbcexamples.Artist;
public interface DAO 
{
	public ArrayList<Artist> getArtists();
	public Artist getArtbyid(int id);
	public Artist addArtist(String name);
	public Artist UpdateArtist(String name,int name2);
	public Artist updateArtist(int id,String name);
}