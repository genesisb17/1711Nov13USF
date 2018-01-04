package com.bank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.domain.User;
import com.bank.api.service.BankService;

/*
 * So that the RESTful web service will include CORS access
 * control headers in its response, you have to add a 
 * @CrossOrigin annotation to the handler method
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/users")
public class BankController {
	
	@Autowired
	BankService service;

	//GET /users = find All
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return service.getAll();
	}
	
	//GET /users/id == find by id
	@RequestMapping(value="/{id}", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public User getById(@PathVariable int id) {
		return service.findById(id);
	}
	
	//POST /users = add user
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	//POST /users/test
	@RequestMapping(method=RequestMethod.POST, value="/byemail", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getByEmail (@RequestBody String email) {
		return service.findByEmail(email);
	}
	
	
	
	
}
