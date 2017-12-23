package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Users;
import com.springboot.service.BankService;

@RestController
@RequestMapping("/api/Bank")
public class BankController {
	@Autowired
	BankService service;
	static 
	{
		System.out.println("in rest conroller");
	}
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody Users u){
		service.addBank(u);
	}
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> findAll() {
		return service.findAllBank();
	}
}
