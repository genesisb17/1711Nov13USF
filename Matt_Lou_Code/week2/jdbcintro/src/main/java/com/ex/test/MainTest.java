package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		
		// notice that toString method is called implicitly
//		ArrayList<Artist> artists = dao.getArtist();
//		for(Artist art: artists) {
//			System.out.println(art);
//		}
		//Artist art = dao.getArtistById(7);
		//System.out.println(art);
		
		/*
		 * appends data on the Artist in the chinook database
		 */
//		System.out.println(dao.addArtist("vic mensa"));
//		System.out.println(dao.updateArtist(1, "genesis"));
		System.out.println(dao.getNameById(2));
	}

}
