package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOimpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOimpl();
		
//		ArrayList<Artist> artists = dao.getArtists();
//		
//		for(Artist art: artists) {
//			System.out.println(art);
//		}
//		
//		Artist art=dao.getArtistById(4);
//		System.out.println(art);
		
//		System.out.println(dao.updateArtistById(1,"Godsmack"));
//		
//		System.out.println(dao.getArtistById(1));
		
		List<Artist> artists=dao.getArtistsStoredProc();
		for(Artist a: artists) {
			System.out.println(a);
		}
	}
}
