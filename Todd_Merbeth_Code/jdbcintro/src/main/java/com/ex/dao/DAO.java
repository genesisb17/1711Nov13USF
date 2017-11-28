package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojo.Artist;

public interface DAO {

	public ArrayList<Artist> getArtists();
	public Artist getArtistsById(int id);
	public Artist addArtist(String name);
	public Artist updateArtist(int id, String name);
	Artist getNameById(int id);
	List<Artist> getArtistsStoredProc();
}
