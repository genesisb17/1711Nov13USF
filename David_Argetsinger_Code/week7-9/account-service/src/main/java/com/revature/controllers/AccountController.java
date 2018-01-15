package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Account;

@RestController
//implies @responsebody vs controller
public class AccountController {
	private List<Account> accounts = new ArrayList<>();
	
	public AccountController(){
		accounts.add(new Account(1,1,13));
		accounts.add(new Account(2,2,21));

		
	}
	
	@GetMapping
	public List<Account> getAll(){
		return accounts;
	}
	
	@GetMapping("{id}")
	public Account findById(@PathVariable int id){
		return accounts.parallelStream().filter(account -> account.getId()==id).findFirst().get();
	}
	
	@GetMapping("test")
	public String test(){
		return"hello world";
	}
	@GetMapping("customer/{id}")
	private List<Account> findByCustomer (@PathVariable int id) {
		return accounts.parallelStream().filter(account->account.getCustomerId()==id).collect(Collectors.toList());

	}
}
