package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	
	User addUser(User person);
	User getUser(String userName);
	User updateMoney(User person, String input);

}
