package com.rev.barberharbor.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private UserRepo users;

	public boolean usernameAvailable(String username) {
		if(users.findByUsernameIgnoreCase(username) == null) return true;
		return false;
	}
	
	public User login(String username, String password) {
		return users.findByUsernameIgnoreCaseAndPassword(username, DigestUtils.sha256Hex(password));
	}
	
	public User register(User u) {
		u.setPassword(DigestUtils.sha256Hex(u.getPassword()));
		return users.save(u);
	}
	
}
