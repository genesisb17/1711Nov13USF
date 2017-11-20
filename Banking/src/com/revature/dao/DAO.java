package com.revature.dao;


import java.util.ArrayList;
import java.util.HashMap;

import com.revature.pojo.User;

public interface DAO {
	
	User addUser(User u);
	ArrayList<String> getUser();
	ArrayList<String> logOn(String us, String pa);
	User withTransac(double amou, double bala);
	User depTransac(double amoun, double balan);
}
