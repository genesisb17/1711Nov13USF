package com.bank3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank3.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Account findByUsernameAndPassword (String username, String password);

}
