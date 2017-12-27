package com.xchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xchange.models.User;
import com.xchange.services.UserService;

@CrossOrigin()
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping(value="/AddNewUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User addUser(@RequestBody User newUser) {
		return service.addUser(newUser);
	}
	
	@RequestMapping(value="/UpdateUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User updateUser(@RequestBody User updatedUser) {
		return service.updateUserById(updatedUser.getUserId(), updatedUser);
	}
	
	@RequestMapping(value="/GetAllUsers", method=RequestMethod.GET)
	public List<User> findAllUsers() {
		System.out.println(service.findAllUsers());
		return service.findAllUsers();
	}
	
	@RequestMapping(value="/GetUserById", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserById(@RequestBody User soughtUser) {
		System.out.println(service.findUserById(soughtUser.getUserId()));
		return service.findUserById(soughtUser.getUserId());
	}
	
	@RequestMapping("/GetUserByUsername")
	public User findUserByUsername(@RequestBody String username) {
		return service.findUserByUsername(username);
	}
	
	@RequestMapping(value="/GetUserByEmail", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public User findUserByEmail(@RequestBody String email) {
		return service.findUserByEmail(email);
	}
	
}
