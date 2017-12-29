package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {

	static DAO dao = new FileDAO();

	public boolean addUser(User user) {
		return dao.addUser(user);
	}

	public User getUser(User user) {
		return dao.getUser(user);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
	}

}
