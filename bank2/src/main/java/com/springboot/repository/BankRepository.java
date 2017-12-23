package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.Users;

@Repository
public interface BankRepository extends JpaRepository<Users, Integer> {
	public Users findUserByUsername(String username);

}
