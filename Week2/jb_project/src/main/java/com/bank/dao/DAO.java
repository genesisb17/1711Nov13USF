package com.bank.dao;
import java.util.ArrayList;

import com.bank.pojos.Accounts;
import com.bank.pojos.Users;

public interface DAO {
	
	public Users addUser(ArrayList<String> input);
	public Accounts addAccount(Integer uid);
	public Integer logOn(String un, String pwd);
}