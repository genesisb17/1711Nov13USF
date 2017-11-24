package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		
	/*	ArrayList<Artist> artists = dao.getArtists();
		
		for(Artist art : artists) {
			System.out.println(art.toString());
		}*/
	/*	
		Artist art = dao.getArtistbyId(4);
		System.out.println(art);
		*/
		
		//System.out.println(dao.addArtist("Vic Mensa"));
		System.out.println(dao.updateArtist(1, "Daniel"));
	}

}
