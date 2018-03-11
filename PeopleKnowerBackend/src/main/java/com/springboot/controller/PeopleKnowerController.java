package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.PeopleKnower;
import com.springboot.service.PeopleKnowerService;

@RestController
@RequestMapping("/api/PeopleKnower")
@CrossOrigin(origins="*")
public class PeopleKnowerController 
{
	@Autowired
	PeopleKnowerService service;
	@RequestMapping(path="/post",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody PeopleKnower p)
	{
		service.addPeopleKnowerUser(p);
	}
	@RequestMapping(path = "/all",method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PeopleKnower> findAll() 
	{
		return service.findAllPeopleKnower();
	}
}
