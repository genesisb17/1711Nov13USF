package com.ex.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.service.DemoService;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
static DemoService service = new DemoService();
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public String test() {
		return "TESTING!";
	}

}
