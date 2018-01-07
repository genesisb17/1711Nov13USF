package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Artist;

public interface DAO {
	
	public ArrayList<Artist> getArtists();
	public Artist getArtistById(int id);
	public Artist addArtist(String name);
<<<<<<< HEAD:Shujun_Ye_Code/Week2/jdbcintro/src/main/java/com/ex/dao/DAO.java
	public Artist updateArtist(int id, String name);
}
=======
	public void updateArtist(int id, String name);
	public List<Artist> getArtistsStoredProc();
	public Artist getNameById(int id);
	
}
>>>>>>> origin:Week2/jdbcintro/src/main/java/com/ex/dao/DAO.java
