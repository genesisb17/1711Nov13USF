package com.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;
import com.ex.repository.Dao;

@RestController
@RequestMapping(value="/flashcard")
public class FlashCardRestController {
	
	@Autowired
	ApplicationContext context;

	@Autowired
	Dao dao;
	
	static {
		System.out.println("in rest conroller");
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody FlashCard fc){
		dao.addFc(fc);
	}
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "TEST";
	}

}
