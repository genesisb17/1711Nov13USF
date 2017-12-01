package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {

	public static void main(String[] args) {
		DAO dao = new DAOImpl();
//		//ctrl shift o
//		ArrayList<Artist> artists= dao.getArtists();
//		for(Artist art:artists){
//			System.out.println(art);
//		}
		//Artist art = dao.getArtistById(4);
		List<Artist> artist = dao.getArtistsStoredProc();
				for (Artist a : artist)
					System.out.println(a);
		// doesn't work System.out.println(dao.getNameById(1));
//		
		//System.out.println(dao.addArtist("Macklemore"));
		//System.out.println(dao.updateArtist(500, "Beyonce"));
		
	}
}
