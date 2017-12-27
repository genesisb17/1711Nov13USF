package com.ex.AngHibBank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.AngHibBank.model.User;
import com.ex.AngHibBank.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	public void addUser(User user) {
		repo.save(user);
	}
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	public Optional<User> getUserById(int id){
		return repo.findById(id);
	}
	
	public User getUserByUsername(String username){
		Optional<User> opt=repo.findByUsername(username);
		User u;
		if(opt.isPresent()) {
			u = opt.get();
		} else {
			u = new User();
		}
		return u;
	}

	@Override
	public void updateUser(User user) {
		repo.deleteById(user.getId());
		repo.save(user);	
	}
	
	
}
