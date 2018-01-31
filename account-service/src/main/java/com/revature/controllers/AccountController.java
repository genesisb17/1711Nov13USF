package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Account;

//implies response body
@RestController
@EnableDiscoveryClient
public class AccountController 
{
	private List<Account> accounts = new ArrayList<>();
	
	public AccountController()
	{
		accounts.add(new Account(1,1,1));
		accounts.add(new Account(2,2,2));
		accounts.add(new Account(3,3,3));

	}
	@GetMapping("test")
	public String test()
	{
		return "<img src='C:\\Users\\Bruce Wayne\\Desktop'>";
	}
	@GetMapping
	public List<Account> getAll()
	{
		return accounts;
	}
	@GetMapping("{id}")
	public Account findById(@PathVariable int id)
	{
		return accounts.parallelStream().filter(account->account.getId()==id).findFirst().get();
	}
	@GetMapping("customer/{id}")
	public List<Account> findByCustomer(@PathVariable int id)
	{
		return accounts.parallelStream().filter(account->account.getCustomerId()==id).collect(Collectors.toList());
	}
}
