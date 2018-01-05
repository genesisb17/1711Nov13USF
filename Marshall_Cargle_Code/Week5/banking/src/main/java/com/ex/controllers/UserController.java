package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.User;
import com.ex.service.service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/banking")
public class UserController {

	@Autowired
	service service;
	
	static {
		System.out.println("in rest conroller");
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addFC(@RequestBody User u){
		User check=service.findUserByEmail(u.getEmail());
		if(check==null)
			return service.addUser(u);
		else
			return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return service.findAllUsers();
	}
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public User findUserByEmail(@PathVariable String email) {
		return service.findUserByEmail(email);
	}
	
	@RequestMapping(value="/id", method = RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE)
	public User findUserById(@RequestBody User user) {
		return service.findUserById(user.getId());
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User login(@RequestBody User user){
		String email = user.getEmail();
		User check = service.findUserByEmail(email);
		if(check==null) return null;
		else {
			if(user.getPassword().equals(check.getPassword())){
				return check;
			}
			else{
				return null;
			}
		}
	}
	
	@RequestMapping(value="/balance", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Double getBalance(@RequestBody User user){
		String email = user.getEmail();
		User check = service.findUserByEmail(email);
		return check.getBalance();
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user){
		Integer id = user.getId();
		User check = service.findUserById(id);
		System.out.println(check.toString());
		System.out.println(user.toString());
		if(!check.getFn().equals(user.getFn()))
			check.setFn(user.getFn());
		if(!check.getLn().equals(user.getLn()))
			check.setLn(user.getLn());
		if(!check.getBalance().equals(user.getBalance()))
			check.setBalance(user.getBalance());
		if(!check.getPassword().equals(user.getPassword()))
			check.setPassword(user.getPassword());
		if(!check.getEmail().equals(user.getEmail()))
			check.setEmail(user.getEmail());
		System.out.println(check.toString());
		service.updateUser(check);
		return check;
	}
	
}
