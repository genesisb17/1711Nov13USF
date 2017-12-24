package com.ex.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping( method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public String test(){
		return "TESTING";
	}

}
