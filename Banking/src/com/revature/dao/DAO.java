package com.revature.dao;


import java.util.ArrayList;
import java.util.HashMap;

import com.revature.pojo.User;

public interface DAO {
	
	User addUser(User u);
	ArrayList<String> getUser();
	ArrayList<String> logOn(String us, String pa);
	void makeTransac(double amou, double bala);
}
