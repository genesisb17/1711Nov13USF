package com.rev.barberharbor.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.User;
import com.rev.barberharbor.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService lserv;
	
	/*
	 *  url: xxxx/login
	 *  method: POST
	 *  parameters: [username: string, password: string]
	 *  returns:  User if sucessfully logged in, null otherwise
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public User login(@RequestBody String[] data) {
		return lserv.login(data[0], data[1]);
	}
	
	/*
	 * url: xxxx/login/username
	 * method: POST
	 * parameters: [username: string]
	 * returns: true if username is available, false if username is taken
	 */
	@CrossOrigin
	@RequestMapping(value="/username", method=RequestMethod.POST)
	public boolean usernameAvailable(@RequestBody String username) {
		return lserv.usernameAvailable(username);
	}
	
	/*
	 * url: xxxx/login/register
	 * method: POST
	 * parameters: User		{email: string, fname: string, lname: string, password: string, username: string, uers_roles_id: number}
	 * returns: User		{users_id: number, email: string, fname: string, lname: string, password: string, username: string, uers_roles_id: number}
	 */
	@CrossOrigin
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User register(@RequestBody User u) {
		return lserv.register(u);
	}
	
	

}
