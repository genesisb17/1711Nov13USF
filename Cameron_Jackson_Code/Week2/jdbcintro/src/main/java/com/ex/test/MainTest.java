package com.ex.test;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {
	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		

		
//		Artist art = dao.getArtistById(6);
//		System.out.println(art);
		
//		System.out.println(dao.addArtist("Vic Mensa"));
		
//		Artist art = dao.updateArtist(118, "Kem");
//		System.out.println(art);
		
//		ArrayList<Artist> artists = dao.getArtists();
//		
//		for (Artist art : artists) {
//			System.out.println(art);
//		}
		
//		System.out.println(dao.getArtistById(1));
		
		List<Artist> artists = dao.getArtistsStoredProc();
		for (Artist a : artists) {
			System.out.println(a);
		}
	}
}
