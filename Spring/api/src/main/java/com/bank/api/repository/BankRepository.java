package com.bank.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.api.domain.User;


@Repository
public interface BankRepository extends JpaRepository<User, Integer>{
	
	public User findUserByEmail(String email);
	
	public boolean existsByEmail(String email);
	
	

}
