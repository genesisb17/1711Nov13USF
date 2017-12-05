package dao;

import pojos.User;

public interface DAO {

	User getUserByUsername(String username);
	User login(String username, String password);
	User signup(User u);
	
}
