package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		
		//ArrayList<Artist> artists = dao.getArtists();
		
		/*
		for(Artist art : artists) {
			System.out.println(art);
		}
		*/
		
		//Artist art = dao.getArtistById(46);
		
		//System.out.println(dao.addArtist("Bob Dole"));
		
		//System.out.println(dao.updateArtist(6, "Deanboi"));

		//System.out.println(dao.getArtistById(1));
		
		List<Artist> artists = dao.getArtistsStoredProc();
		for(Artist a : artists) {
			System.out.println(a);
		}
	}

}
