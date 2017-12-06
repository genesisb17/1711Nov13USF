package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {
	
	public static void main(String[] args) {
		
		
		DAO dao = new DAOImpl();
		
/*		ArrayList<Artist> artists = dao.getArtists();	
		for(Artist art : artists) {
			System.out.println(art);
		}
		
		Artist art = dao.getArtistById(4);
		System.out.println(art);*/
		
		//System.out.println(dao.addArtist("Vic Mensa"));
		//System.out.println(dao.updateById(501, "Chance the Rapper"));
		//
		//Artist art = new Artist();
		//System.out.println(dao.getArtistById(1));
		
		List<Artist> artists = dao.getArtistsStoredProc();
		for (Artist a : artists) {
			System.out.println(a);
		}
		
	}

}
