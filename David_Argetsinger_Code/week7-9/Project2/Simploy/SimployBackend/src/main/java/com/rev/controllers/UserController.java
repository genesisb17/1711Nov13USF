package com.rev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.domain.User;
import com.rev.service.UserService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/User")
public class UserController {

	@Autowired
	UserService service;

	static {
		System.out.println("in rest conroller");
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		return service.findAllUsers();
	}
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addFC(@RequestBody User u){
		User check=service.findUserByEmail(u.getEmail());
		if(check==null) {
			System.out.println("test");
			return service.addUser(u);
		}else
			return null;
	}
	
	@CrossOrigin()
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
	
	@CrossOrigin()
	@RequestMapping(value="/update", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody User user){
		Integer id = user.getId();
		User check = service.findUserById(id);
		System.out.println(check.toString());
		System.out.println(user.toString());
		if(!check.getFirstName().equals(user.getFirstName()))
			check.setFirstName(user.getFirstName());
		if(!check.getLastName().equals(user.getLastName()))
			check.setLastName(user.getLastName());
		if(!check.getPnumber().equals(user.getPnumber()))
			check.setPnumber(user.getPnumber());
		if(!check.getPassword().equals(user.getPassword()))
			check.setPassword(user.getPassword());
		if(!check.getEmail().equals(user.getEmail()))
			check.setEmail(user.getEmail());
		if(!check.getRole().equals(user.getRole()))
			check.setRole(user.getRole());
		System.out.println(check.toString());
		service.updateUser(check);
		return check;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User findById(@RequestBody User user){
		Integer id = user.getId();
		return service.findUserById(id);
	}

}
