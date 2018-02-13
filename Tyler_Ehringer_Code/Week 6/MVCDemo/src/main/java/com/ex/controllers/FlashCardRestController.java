package com.ex.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;
import com.ex.service.DemoService;

@RestController
@RequestMapping("/flashcard")
public class FlashCardRestController {

	static DemoService service;
	static {
		service = new DemoService();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FlashCard getById(@PathVariable int id) {
		System.out.println("in method");
		return service.getById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<FlashCard> getAll() {
		return service.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public FlashCard addFlashCard(@RequestBody FlashCard fc) {
		fc = service.addCard(fc);
		return fc;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public FlashCard updateFlashCard(@PathVariable int id, @RequestBody FlashCard fc) {
		service.getById(id).setAnswer(fc.getAnswer());
		service.getById(id).setQuestion(fc.getQuestion());
		return service.getById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String deleteFlashCard(@PathVariable int id) {
		if(service.deleteFlashCard(id)) return "true";
		else return "Whatcha doin? deleting things that don't exist!";
	}

}
