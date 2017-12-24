package com.rev.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.bank.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findUserByUsername(String username);
	public User findUserByUsernameAndPassword(String username, String password);
}
