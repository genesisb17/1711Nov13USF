package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public User findUserByEmail(String email);
}
