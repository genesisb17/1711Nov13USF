package com.revature.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("test")
	public String test() {
		return "hello world";
	}
}
