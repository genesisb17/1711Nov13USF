package com.ex.controllers;

import java.util.List;

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
@RequestMapping("flashcard")
@CrossOrigin(origins="/")
public class FlashCardRestController {
	static DemoService service=new DemoService();
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces="applications/json")
	public FlashCard getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard addFC(@RequestBody FlashCard fc) {
		fc=service.addCard(fc);
		return fc;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard deleteFC(@RequestBody int id ) {
		FlashCard fc=service.getById(id);

		return fc;
	}
}