package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {
	
	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		ArrayList<Artist> artists = dao.getArtists();
//		for(Artist a : artists) {
//			System.out.println(a.toString());
//		}
//		
//		Artist art = dao.getArtist(4);
//		System.out.println(art);
		
		System.out.println(dao.getNameById(4));
//		dao.getArtistsStoredProc().stream().forEach(System.out::println);
//		
//		System.out.println(dao.updateArtist(500, "It does work"));
	}

}
