package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ex.model.User;

@Repository
public interface BankRepository extends JpaRepository<User, Integer>{

	public List<User> findUserByEmail(String email);
	public List<User> findByUsernameAndPassword(String username, String password);
}
