package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		
		DAO dao = new DAOImpl();
		
		/*System.out.println("Running getAllArtists() (Java-side execution)");
		ArrayList<Artist> artists = dao.getAllArtists();
		
		for(Artist artist : artists) {
			System.out.println(artist);
		}*/
		
		/*Artist art = dao.getArtistbyId(4);
		System.out.println(art);*/
		
		/*System.out.println(dao.addArtist("Vic Menda"));*/
		
		/*System.out.println(dao.updateArtist(276, "Vic Mensa"));*/
		
		/*System.out.println(dao.getArtistById(13));*/
		
		/*System.out.println("+------------------------------------+");
		System.out.println("Running getAllArtistsStoredProc() (precompiled on DB)");
		for (Artist a : dao.getAllArtistsStoredProc()) {
			System.out.println(a);	
		}*/
	}
	
}
