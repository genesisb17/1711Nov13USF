package com.boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.User;
import com.boot.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService service;
	
	static {
		System.out.println("IN REST CONTROLLER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return service.findAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		service.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/findByEmail", consumes=MediaType.TEXT_PLAIN_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User findByEmail(@RequestBody String email) {
/*		User user = new User();
		user = service.findUserByEmail(email);
		
		System.out.println("This is the user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + user);*/
		
		return service.findUserByEmail(email);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/findByEmailAndPassword", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User findByEmailAndPassword(@RequestBody Map<String, String> json) {
		
		String email2 = json.get("email");
		String password2 = json.get("password");
		
		User user = new User();
		user = service.findUserByEmailAndPassword(email2, password2);
		
		System.out.println("This is the user!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + user);
		
		return service.findUserByEmailAndPassword(email2, password2);
	}
	
}
