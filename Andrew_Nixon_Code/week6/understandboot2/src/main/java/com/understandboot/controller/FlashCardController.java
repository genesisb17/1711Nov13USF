package com.understandboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.understandboot.model.FlashCard;
import com.understandboot.service.FlashCardService;

@RestController
@RequestMapping("/api/flashcard")
public class FlashCardController {
	
	@Autowired
	FlashCardService service;
	
	static {
		System.out.println("Inside Rest Contoller");
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFlachCard(@RequestBody FlashCard fc) {
		service.addFlashCard(fc);
	}
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> findAll() {
		return service.findAllFlashCards();
	}
	
}
