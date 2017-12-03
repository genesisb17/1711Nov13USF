package com.rev.dao;

import com.rev.pojos.Users;

public interface DAO {
	Users addUser(Users u);
	Users getUser(String username);
	Users update(Users u);
}
