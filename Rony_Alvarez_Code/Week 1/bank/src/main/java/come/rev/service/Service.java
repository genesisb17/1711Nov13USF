package come.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();
	public User addUser(User u) {
		// validate that username does not exist 
		// assuming that it does not exist
		dao.addUser(u);
		return u;
	}
	
}
