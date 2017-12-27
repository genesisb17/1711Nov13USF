package com.revature.controller.rest;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.AppUser;

@RestController
@RequestMapping("users")
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

	@PostMapping("login")
	public ResponseEntity<Boolean> login(@RequestBody AppUser u, HttpServletResponse resp) {
		if ("admin".equals(u.getUsername()) && "pass".equals(u.getPassword())) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Set-Cookie","username="+u.getUsername());
			headers.add("Set-Cookie","password="+u.getPassword());
			ResponseEntity.status(HttpStatus.OK).headers(headers).build();
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
	}

	@GetMapping
	public void testCookie(HttpServletRequest req) {
		Enumeration<String> headers = req.getHeaderNames();
		while(headers.hasMoreElements()) {
			System.out.println(req.getHeader(headers.nextElement()));
		}
		System.out.println(req.getHeader("myHeaderName"));
	}
}
