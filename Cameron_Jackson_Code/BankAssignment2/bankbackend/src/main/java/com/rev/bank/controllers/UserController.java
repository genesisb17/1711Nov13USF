package com.rev.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.bank.domain.User;
import com.rev.bank.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User u) {
		User user = userService.updateUser(u);
		return user;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}
	
	@RequestMapping(value="/username", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestBody User u) {
		return userService.findUserByUsername(u.getUsername());
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsernameAndPassword(@RequestBody User u) {
		return userService.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
}
