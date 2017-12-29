package com.ex.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.service.FlashCardService;
import com.ex.domain.FlashCard;
import com.ex.service.DemoService;

@RestController
@RequestMapping("/flashcard")
public class FlashCardRestController {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	static FlashCardService fcService = (FlashCardService) context.getBean("flashCardServiceImpl");
	
	static DemoService service = new DemoService();
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
	public FlashCard getById(@PathVariable int id) {
		return service.getById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<FlashCard> getAll() {
		return fcService.findAllFlashCards();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void addFC(@RequestBody FlashCard fc) {
		fcService.addFlashCard(fc);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<FlashCard> updateFc(@RequestBody FlashCard fc) {
		FlashCard card = service.update(fc);
		if(card == null) return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<FlashCard>(card, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<FlashCard> deleteFc(@RequestBody FlashCard fc) {
		if(fc == null) return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		else {
			service.delete(fc);
			return new ResponseEntity<FlashCard>(fc, HttpStatus.OK);
		}
	}
}
