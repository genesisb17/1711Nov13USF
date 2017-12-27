package com.rev.bootbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.bootbank.model.User;
import com.rev.bootbank.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User getUser(Long id) {
		return repo.findOne(id);
	}

	public boolean usernameAvailable(String username) {
		return repo.findByUsernameIgnoreCase(username) == null;
	}
	
	public User login(String username, String password) {
		return repo.findByUsernameIgnoreCaseAndPassword(username, password);
	}
	
	public User addUser(User u) {
		return repo.save(u);
	}
	
	public User updateUser(User u) {
		return repo.save(u);
	}

}
