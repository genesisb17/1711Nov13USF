package com.xchange.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	static {
		System.out.println("[LOG] - In TestController");
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public String test() {
		return "testing";
	}

}
