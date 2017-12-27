package com.revature.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.SuperBar;

@RestController
@RequestMapping("/superbars")
@CrossOrigin(value="http://localhost:4200")
public class SuperBarController {
	private List<SuperBar> superBars;
	
	public SuperBarController() {
		superBars = new ArrayList<>();
		superBars.add(new SuperBar("snickers", 1, "50", 7));
		superBars.add(new SuperBar("kit kat", 2, "Sugar", 8));
		superBars.add(new SuperBar("milkey way", 3, "Galaxies", 5));
		superBars.add(new SuperBar("Reeses", 4, "Super awesome", 7));
		superBars.add(new SuperBar("twix", 5, "Left Twix", 10));
		superBars.add(new SuperBar("foobar", 6, "confusing", 1));
	}
	
	@GetMapping
	public List<SuperBar> getAllBars() {
		return superBars;
	}
}
