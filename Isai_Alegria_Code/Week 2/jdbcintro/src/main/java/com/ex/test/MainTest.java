package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.DAO.*;
import com.ex.pjos.Artist;

public class MainTest {
	
	public static void main(String[] args) {
		
		DAO dao = new DAOImpl();
		
		//ArrayList<Artist> artists = dao.getArtists();
		
		//for(Artist art: artists) {
		//	System.out.println(art);
		//}
		
		//Artist art = dao.getArtistsById(4);
		//System.out.println(art);
		
		//System.out.println(dao.addArtist("Jaden Smith"));
		//System.out.println(dao.updateById(2,"gucci mane"));
		
		//System.out.println(dao.getArtistsById(1));

		List<Artist> artists = dao.getArtistsStoredProc();
		for(Artist a: artists) {
			
			System.out.println(a);
		}
		
		//for(Artist art: artists) {
		//	System.out.println(art);
		//}
		
		//Artist art = dao.getArtistsById(4);
		//System.out.println(art);
		
	}

}
