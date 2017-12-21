package com.ex.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;
import com.ex.service.DemoService;

@RestController
@RequestMapping(value= "/flashcard")
public class FlashCardRestController {

	static DemoService service = new DemoService();

	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getById(@PathVariable Integer id) {
		return service.getCardById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAll() {
		return service.getAll();
	}

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard addFC(@RequestBody FlashCard fc) {
		fc = service.addCard(fc);
		return fc;
	}

	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlashCard> updateFC(@RequestBody FlashCard fc) {
		FlashCard card = service.updateCard(fc);
		if (card == null) return new ResponseEntity<FlashCard>(HttpStatus.I_AM_A_TEAPOT);
		else {return new ResponseEntity<FlashCard>(card, HttpStatus.OK);}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<FlashCard> deleteFC(@PathVariable Integer id) {
		System.out.println("here");
		
		service.deleteCard(id);
		
		return new ResponseEntity<FlashCard>(HttpStatus.OK);
	}

}
