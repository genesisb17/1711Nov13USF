package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.FlashCard;
import com.boot.service.DemoService;
import com.boot.service.FlashCardService;


@RestController
@RequestMapping("api/flashcard")
public class FlashCardController {
	
	@Autowired
	FlashCardService service;
	
	static {
		System.out.println("in rest conroller");
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody FlashCard fc){
		service.addFlashCard(fc);
	}
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> findAll() {
		return service.findAllFlashCards();
	}

}
