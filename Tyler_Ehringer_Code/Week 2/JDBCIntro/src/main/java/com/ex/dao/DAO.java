package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Artist;

public interface DAO {
	
	public Artist getArtist(int artistId);
	public Artist addArtist(String a);
	public ArrayList<Artist> getArtists();
	public Artist updateArtist(int artistid, String name);
	
	public Artist getNameById(int id);
	
	public List<Artist> getArtistsStoredProc();

}
