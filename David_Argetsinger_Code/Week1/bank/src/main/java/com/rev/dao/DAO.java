package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	User addUser(User u );
	User getUser(String username);
	//update the user ( NEED TO UPDATE ENTIRE FILE)
	User updateUser(String username, double update);
	
		
		
	
	//service layer will make sure the rules are followed 
	// balanace stuff here add sub 
}
