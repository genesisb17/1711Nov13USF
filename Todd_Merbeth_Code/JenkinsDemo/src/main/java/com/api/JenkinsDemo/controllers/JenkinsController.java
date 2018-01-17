package com.api.JenkinsDemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to your Jenkins Demo App";
	}
}
