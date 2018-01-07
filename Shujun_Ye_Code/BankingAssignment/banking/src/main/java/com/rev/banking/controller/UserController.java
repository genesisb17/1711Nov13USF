package com.rev.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.banking.domain.User;
import com.rev.banking.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200") // required because we’ll be accessing the apis from angular’s frontend server
public class UserController {

//	@Autowired
//	ApplicationContext context;
//	
//	private UserService userService = (UserService) context.getBean("userServiceImpl");
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll(){
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}
	
	@RequestMapping(value="/username", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@RequestBody String username) {
		return userService.findUserByUsername(username);
	}

	@RequestMapping(value="/email", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@RequestBody String email) {
		return userService.findUserByEmail(email);
	}

	@RequestMapping(value="/auth", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsernameAndPassword(@RequestBody User u) {
		return userService.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody User u) {
		userService.addUser(u);
	}

	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
		
	}	
}
