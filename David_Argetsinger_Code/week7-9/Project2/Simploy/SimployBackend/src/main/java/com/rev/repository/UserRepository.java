package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByEmail(String email);
	public User findUserByUserId(Integer id);
}
