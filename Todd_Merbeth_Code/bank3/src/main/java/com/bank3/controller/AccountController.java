package com.bank3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank3.model.Account;
import com.bank3.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@CrossOrigin
	@RequestMapping(value="/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Account addAccount(@RequestBody String[] data) {
		Account acc = new Account(data[0], data[1], data[2], data[3], data[4]);
		service.addAccount(acc);
		return acc;
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public List<Account> findAllAccounts(){
		return service.findAllAccounts();
	}

	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Account login(@RequestBody String[] data) {
		return service.login(data[0], data[1]);
	}
	
	@CrossOrigin
	@RequestMapping(value="/deposit", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account deposit(@RequestBody String[] data) {
		return service.deposit(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
	}
	
	@CrossOrigin
	@RequestMapping(value="/withdraw", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account withdraw(@RequestBody String[] data) {
		return service.withdraw(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
	}
}
