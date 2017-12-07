package com.ex.test;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.User;

public class Test {

	public static void main(String[] args) {
		DAO dao = new DAOImpl();
		User u = dao.getUser("EML");
		if (u == null){
			System.out.println("null");
		}
		System.out.println(u);
		
	}

}
