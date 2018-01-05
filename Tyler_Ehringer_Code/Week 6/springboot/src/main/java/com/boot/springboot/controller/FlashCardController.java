package com.boot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.springboot.model.FlashCard;
import com.boot.springboot.service.FlashCardService;

@RestController
@RequestMapping("/api/flashcard")
public class FlashCardController {
	
	@Autowired
	FlashCardService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addFc(@RequestBody FlashCard fc) {
		service.addFlashCard(fc);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<FlashCard> getFcs(){
		return service.getAllFlashcards();
	}
	
}
