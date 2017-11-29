package com.ex.test;

import java.util.List;

//import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;
//import com.ex.pojos.Artist;

public class MainTest
{

	public static void main(String[] args)
	{

		DAO dao = new DAOImpl();

		/*
		 * ArrayList<Artist> artists = dao.getArtists();
		 * 
		 * for(Artist art : artists) { System.out.println(art); }
		 * 
		 * Artist art = dao.getArtistById(5); System.out.println(art);
		 */

		// System.out.println(dao.addArtist("Vic Vaness"));

		// System.out.println(dao.updateArtist(1, "John"));

		// System.out.println(dao.getArtistById(1));

		List<Artist> artists = dao.getArtistsStoredProc();
		for (Artist a : artists)
		{
			System.out.println(a);
		}
	}

}
