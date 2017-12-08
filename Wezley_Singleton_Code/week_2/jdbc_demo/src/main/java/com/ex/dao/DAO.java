package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Artist;

public interface DAO {

	public ArrayList<Artist> getAllArtists();
	public Artist getArtistById(int id);
	public Artist addArtist(String name);
	public Artist updateArtist(int id, String newName);
	public List<Artist> getAllArtistsStoredProc();
	public Artist getNameById(int id);
	
}
