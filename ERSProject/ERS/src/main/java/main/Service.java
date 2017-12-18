package main;

import java.util.ArrayList;

import dao.DAO;
import dao.DAOImpl;
import pojos.DTO;
import pojos.User;

public class Service {

	static DAO dao = new DAOImpl();
	
	public User validateUser(String username, String password){
		System.out.println("In ValidaUser Function");
		User user = dao.getUser(username, password);
		//if(user.getId()==0)
		System.out.println(user.getId() + " " + user.getUsername());
		return user;
	}

	public User login(int id, String pass){
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}

	public User addUser(User u){
		System.out.println("Username in add user service layer is " + u.getUsername());
		int id = dao.addUser(u.getUsername(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getPassword());
		u.setId(id);
		return u;
	}

	public User validateUser(String username) {
		User u = dao.getUser(username);
		return u;
	}

	public int submitRequest(DTO submission) {
		System.out.println("Inside service submitRequest function");
		int id = dao.submitReimRequest(submission);
		return id;
	}
	public User updateUser(String username, String firstname, String lastname, String email ) {
		System.out.println("In the service layer, executing update user");
		User u = dao.updateUser(username, firstname, lastname, email);
		System.out.println(u);
		return u;
	}
	public int updatePassword(String username, String password) {
		System.out.println("In the service layer, executing update password");
		int update = dao.updatePassword(username, password);
		return update;
		
	}

	public ArrayList<DTO> getRequests(User u) {
		ArrayList<DTO> data = dao.getRequests(u);
		return data;
	}
	


}
	
