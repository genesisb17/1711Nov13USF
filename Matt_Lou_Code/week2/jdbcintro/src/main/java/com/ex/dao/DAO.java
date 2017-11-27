package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Artist;

public interface DAO {
	public ArrayList<Artist> getArtist();
	public Artist getArtistById(int id);
	public Artist addArtist(String name);
	public Artist updateArtist(int id, String name);
}
