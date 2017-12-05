package dao;

import pojos.User;

public interface DAO {

	User getUser(String email,String password);

	User getUserById(int id);

	int addUser(String username, String firstname, String lastname, String email, String password);

	User getUser(String username);
}
