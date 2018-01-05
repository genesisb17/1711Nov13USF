package com.ex.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
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
import com.ex.service.FlashCardService;

@RestController
@RequestMapping(value = "/flashcard")
public class FlashCardRestController {

	static DemoService service = new DemoService();
	static {
		System.out.println("in flashcard controller");
	}
	
	static ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
	
	static FlashCardService fcService = (FlashCardService)context.getBean("flashCardServiceImpl");

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getById(@PathVariable int id) {
		System.out.println("in get by id");
		return service.getById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAll() {
		//return service.getAll();
		return fcService.findAllFlashCards();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addFC(@RequestBody FlashCard fc) {
		//fc = service.addCard(fc);
		fcService.addFlashCard(fc);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateFc(@RequestBody FlashCard fc) {
		FlashCard card = service.update(fc);
		if (card == null)
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<FlashCard>(card, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> deleteFc(@PathVariable int id) {
		FlashCard old = service.deleteFc(id);
		if (old == null)
			return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<FlashCard>(old, HttpStatus.OK);
	}

}
