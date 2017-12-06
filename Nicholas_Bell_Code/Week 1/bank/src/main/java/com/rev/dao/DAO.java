package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	
	User addUser(User u);
	User getUser(String username);
	User changeBalance(User u, boolean c, double d);

}
