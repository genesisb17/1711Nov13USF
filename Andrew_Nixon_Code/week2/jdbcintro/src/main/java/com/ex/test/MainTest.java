package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOimp;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOimp();
		
		List<Artist> artists = dao.getArtistByStoredProcedure();
		
		for(Artist art: artists) {
			System.out.println(art);
		}
		
		
		Artist art = dao.getArtistById(4);
		System.out.println(art);
		
		/*
		Artist art2 = dao.getNameById(4);
		System.out.println(art2);
		*/
	}
	
	

}
