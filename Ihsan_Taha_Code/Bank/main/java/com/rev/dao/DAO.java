package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	boolean addUser(User user);

	User getUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

}
