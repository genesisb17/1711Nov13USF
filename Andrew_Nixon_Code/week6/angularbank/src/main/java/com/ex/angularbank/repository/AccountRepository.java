package com.ex.angularbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.angularbank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	//public Account findAccountById(Integer id);
	public Account findAccountByEmail(String email);


}
