package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.User;
import com.boot.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {
	
	
	
	@Autowired
	UserService service;
	
	static {
		System.out.println("in rest conroller");
	}

//	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public void addU(@RequestBody User u){
//		service.addUser(u);
//	}
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return service.findAllUsers();
	}
	//@getmapping
	//@postmapping
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping()
	public User updateUser(@RequestBody User u) {
		System.out.println("in update user "+ u);
		User user = service.updateUser(u);
		
		return user;
	}

	@CrossOrigin
	@RequestMapping(value="/namecheck", method = RequestMethod.POST)
	public User findUserByUsername(@RequestBody String username) {
		return service.findUserByUsername(username);
	}
	//need to add in an update balance 
	// add in edit user 
	//this is done in the service / impl 

}
