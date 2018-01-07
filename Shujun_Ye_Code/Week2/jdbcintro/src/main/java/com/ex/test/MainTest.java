package com.ex.test;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Artist;

public class MainTest {
	public static void main(String[] args) {
		DAO dao = new DAOImpl();
<<<<<<< HEAD:Shujun_Ye_Code/Week2/jdbcintro/src/main/java/com/ex/test/MainTest.java
		

		
//		Artist art = dao.getArtistById(6);
//		System.out.println(art);
		
//		System.out.println(dao.addArtist("Vic Mensa"));
		
//		Artist art = dao.updateArtist(117, "The Ohio Players");
//		System.out.println(art);
		
		ArrayList<Artist> artists = dao.getArtists();
		
		for (Artist art : artists) {
			System.out.println(art);
		}
	}
}
=======
		//		
		//		ArrayList<Artist> artists = dao.getArtists();
		//	
		//		for(Artist art : artists){
		//			System.out.println(art);		}
		//			Artist art = dao.getArtistById(4);
		//		System.out.println(art);

		//	System.out.println(dao.addArtist("Genesis Bonds"));
		//dao.updateArtist(1, "TESTING");
		//	System.out.println("done");

			List<Artist> artists = dao.getArtistsStoredProc();
			for(Artist a : artists){
				System.out.println(a);
			}
			}
		
	//	System.out.println(dao.getArtistById(505));	
	
}
>>>>>>> origin:Week2/jdbcintro/src/main/java/com/ex/test/MainTest.java
