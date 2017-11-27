package com.ex.DAO;

import java.util.ArrayList;

import com.ex.pjos.Artist;

public interface DAO {
	
	public ArrayList<Artist> getArtists();
	public Artist getArtistsById(int id);
	public Artist addArtist(String name);
	public Artist updateById(int id,String name);

}
