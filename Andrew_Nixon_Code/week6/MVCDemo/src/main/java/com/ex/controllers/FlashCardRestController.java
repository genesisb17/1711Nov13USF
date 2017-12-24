package com.ex.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;
import com.ex.service.DemoService;

@RestController
@RequestMapping(value="/flashcard")
@CrossOrigin
public class FlashCardRestController {
	
	static DemoService service = new DemoService();
	static {
		System.out.println("in FC Controller");
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getById(@PathVariable int id) {
		System.out.println("in get by id");
		return service.getById(id).toString();
	}
	
//	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlashCard addFlashCard(@RequestBody FlashCard flashCard) {
		System.out.println("in add FlashCard");
		return service.add(flashCard);
	}
	
	//public ResponseEntity<FlashCard> update
 
}
