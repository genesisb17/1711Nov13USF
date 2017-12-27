package com.revature.controller.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.AppUser;

@RestController
@RequestMapping("users")
@CrossOrigin(value="http://localhost:4200")
public class UserController {

	@PostMapping("login")
	public boolean login(@RequestBody AppUser u, HttpServletResponse resp) {
		if("admin".equals(u.getUsername())&&"pass".equals(u.getPassword())) {
			resp.addCookie(new Cookie("username",u.getUsername()));
			resp.addCookie( new Cookie("password",u.getPassword()));
			return true;
		}
		return false;
	}
	
	@GetMapping
	public void testCookie(HttpServletRequest req) {
		for(Cookie cook:req.getCookies()) {
			System.out.println(cook.getName());
			System.out.println(cook.getValue());
		}
	}
}