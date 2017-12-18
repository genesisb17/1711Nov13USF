package dao;

import java.util.ArrayList;

import pojos.DTO;
import pojos.User;

public interface DAO {

	User getUser(String email,String password);

	User getUserById(int id);

	int addUser(String username, String firstname, String lastname, String email, String password);

	User getUser(String username);

	int submitReimRequest(DTO submission);
	
	User updateUser(String username, String firstname, String lastname, String email);
	
	int updatePassword(String username, String password);

	ArrayList<DTO> getRequests(User u);
}
