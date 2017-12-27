package com.ex.AngHibBank.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.AngHibBank.model.Creds;
import com.ex.AngHibBank.model.User;
import com.ex.AngHibBank.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin(value="http://localhost:4200")
public class UserRestController {
	
	@Autowired
	UserService service;
	
	//@GetMapping("/api/hi", produces=MediaType.TEXT)
	@RequestMapping(path="/api/hi", method=RequestMethod.GET)
	public String hi() {
		return "{\"text\":\"Hello World from REST Controller!!!\"}";
	}
	
	@GetMapping("/getAll")
	public String getUsers() {
		List<User> users=service.getAllUsers();
		String json= "{\"text\":\"didn't transfer information\"}";
		ObjectMapper om=new ObjectMapper();
		try {
			json=om.writeValueAsString(users);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@PostMapping("/testPost")
	public void testPost(@RequestBody String sentBack) {
		System.out.println(sentBack);
	}
	
	@PostMapping("/addUser")
	public String checkUsername(@RequestBody String potentialUser) {
		ObjectMapper om = new ObjectMapper();
		String check="{\"check\":\"valid\"}";
		try {
			User u=om.readValue(potentialUser,User.class);
			String userToCheck=u.getUsername();
			User uInDB=service.getUserByUsername(userToCheck);
			if(uInDB.getId()!=0) {
				check="{\"check\":\"invalid\"}";
			} else {
				service.addUser(u);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody String credentials) {
		ObjectMapper om = new ObjectMapper();
		String json="";
		//actually initialize json to empty user
		try {
			json = om.writeValueAsString(new User());
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//validate in the try-block, making json non-empty user
		try {
			Creds creds=om.readValue(credentials, Creds.class);
			String username=creds.getUsername();
			String password=creds.getPassword();
			User maybeUser=service.getUserByUsername(username);
			if(maybeUser.getId()!=0) {
				if(maybeUser.getPw().equals(password)) {
					json = om.writeValueAsString(maybeUser);
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return json;
	}
	
	@PostMapping("/updateUser")
	public void update(@RequestBody String updated){
		ObjectMapper om = new ObjectMapper();
		try {
			User toUpdate=om.readValue(updated, User.class);
			service.updateUser(toUpdate);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
