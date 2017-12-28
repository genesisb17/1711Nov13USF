package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByEmail(String email);
	public User findUserByEmailAndPassword(String email, String password);
	
}
