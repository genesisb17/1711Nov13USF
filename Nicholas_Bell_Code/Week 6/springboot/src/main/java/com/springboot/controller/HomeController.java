package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")//This is an MVC annotation, abstracted by spring boot
	public String welcome() {
		return "Welcome to Spring Boot";
	}
	
	

}
