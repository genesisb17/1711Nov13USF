package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.FlashCard;
import com.springboot.service.FlashCardService;


@RestController
@RequestMapping("/api/flashcard")
public class FlashCardController {

	@Autowired
	FlashCardService service;
	
	static {
		System.out.println("In rest controller");
	}
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<FlashCard> getAll() {
		return service.findAllFlashCards();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void addFC(@RequestBody FlashCard fc) {
		service.addFlashCard(fc);
	}
}
