package dao;

import pojos.User;

public interface DAO {

	User getUserByUsername(String username);
	
}
