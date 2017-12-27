package com.rev.bootbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rev.bootbank.model.User;
import com.rev.bootbank.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	//localhost:xxxx/username (username: string)
	@CrossOrigin
	@RequestMapping(value="/username", method=RequestMethod.POST)
	public boolean usernameAvailable(@RequestBody String username) {
		return service.usernameAvailable(username);
	}
	
	//localhost:xxxx/register (user: User)
	@CrossOrigin
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User register(@RequestBody User u) {
		return service.addUser(u);
	}
	
	//localhost:xxxx/login ([username: string, password: string])
	@CrossOrigin
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User login(@RequestBody String[] data) {
		return service.login(data[0], data[1]);
	}
	
	//localhost:xxxx/deposit ({id: number, amount: number})
	@CrossOrigin
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public User deposit(@RequestBody ObjectNode json) {
		User u = service.getUser(json.get("id").asLong());
		u.setBalance(u.getBalance() + json.get("amount").asDouble());
		return service.updateUser(u);
	}
	
	//localhost:xxxx/profile (user: User)
	@CrossOrigin
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public User profile(@RequestBody User u) {
		return service.updateUser(u);
	}

}
