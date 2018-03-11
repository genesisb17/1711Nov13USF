package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Relations;
import com.springboot.service.RelationsService;

@RestController
@RequestMapping("/api/Relations")
public class RelationController 
{
/*	@Autowired
	RelationsService service;
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody Relations p)
	{
		service.addPeopleKnowerUser(p);
	}
	@CrossOrigin
	@RequestMapping(path = "/all",method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Relations> findAll() 
	{
		return service.findAllPeopleKnower();
	}*/
}
