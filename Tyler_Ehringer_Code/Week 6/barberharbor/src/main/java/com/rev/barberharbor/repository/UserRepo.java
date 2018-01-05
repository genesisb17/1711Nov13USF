package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	public User findByUsernameIgnoreCase(String username);
	
	public User findByUsernameIgnoreCaseAndPassword(String username, String password);

}
