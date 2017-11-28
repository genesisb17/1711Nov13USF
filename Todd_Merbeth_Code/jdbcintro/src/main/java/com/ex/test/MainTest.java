package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImp1;
import com.ex.pojo.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOImp1();
//		ArrayList<Artist> artists = dao.getArtists();
//		
//		for(Artist art: artists) {
//			System.out.println(art);
//		}
//		Artist art = dao.getArtistsById(4);
//		System.out.println(art);
		
//		System.out.println(dao.addArtist("Vic Mensa"));
//		System.out.println(dao.updateArtist(500, "Beyonce"));
//		System.out.println(dao.getArtistsById(1));
		List<Artist> artists = dao.getArtistsStoredProc();
		
		for(Artist art: artists) {
			System.out.println(art);
		}
	}

}
