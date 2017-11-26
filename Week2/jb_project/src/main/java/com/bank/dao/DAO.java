package com.bank.dao;
import java.util.ArrayList;

import com.bank.pojos.Users;

public interface DAO {
	
	public Users addUser(ArrayList<String> input);
	public Users logOn(String un, String pwd);
}