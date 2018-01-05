package com.api.jenkinsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(value="/")
	public String welcome() {
		return "Welcome to the Jenkins demo app";
	}
}
