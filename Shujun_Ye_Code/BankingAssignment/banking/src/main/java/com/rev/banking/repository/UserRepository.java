package com.rev.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rev.banking.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);
	User findUserByEmail(String email);
	User findUserByUsernameAndPassword(String username, String password);
	
}
