package com.bank3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
		
	@RequestMapping("/")
	public String welcome() {
		return "Bank Home";
	}

}
