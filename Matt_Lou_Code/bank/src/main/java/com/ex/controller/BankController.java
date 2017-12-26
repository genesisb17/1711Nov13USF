package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.User;
import com.ex.service.BankService;

@RestController
@RequestMapping("/api")
public class BankController {
	
	@Autowired
	BankService service;
	
	@CrossOrigin
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		service.addUser(user);
	}
	
	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public List<User> login(@RequestBody User user) {
		return service.login(user);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAllUsers(){
		return service.findAllUsers();
	}

//	@RequestMapping(method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public User findUserById(Integer id) {
//		return service.findUserById(id);
//	}

	@CrossOrigin
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void updateUser(@RequestBody User user) {
		service.updateUser(user);
	}
	
	@CrossOrigin
	@RequestMapping(value="/deposit", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deposit(@RequestBody User user) {
		service.deposit(user);
	}
	
	@CrossOrigin
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public void withdraw(@RequestBody User user) {
		service.withdraw(user);
	}
	
}

