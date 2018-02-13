package com.rev.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rev.entities.Account;

@RestController
public class AccountController {

	private List<Account> accounts = new ArrayList<>();
	
	public AccountController() {
		accounts.add(new Account(1, 1, 3.50));
		accounts.add(new Account(2, 2, 5.52));
		accounts.add(new Account(3, 1, 999.83));
		accounts.add(new Account(4, 2, 1));
		accounts.add(new Account(5, 3, 0));
		accounts.add(new Account(6, 4, 0.99));
		accounts.add(new Account(7, 1, 10.24));
		accounts.add(new Account(8, 2, 89.42));

	}
	
	@GetMapping
	public List<Account> getAll() {
		return accounts;
	}
	
	@GetMapping("/{id}")
	public Account findById(@PathVariable int id) {
		return accounts.parallelStream().filter(a -> a.getId() == id).findFirst().get();
	}
	
	@GetMapping("/customer/{id}")
	public List<Account> findByCustomerId(@PathVariable int id){
		return accounts.stream().filter(a -> a.getCustomerId() == id).collect(Collectors.toList());
	}
	
	
	
}
