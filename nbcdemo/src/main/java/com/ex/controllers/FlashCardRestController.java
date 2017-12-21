package com.ex.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.domain.FlashCard;
import com.ex.service.DemoService;

@RestController
@RequestMapping("flashcard")
@CrossOrigin(origins="/")
public class FlashCardRestController 
{
	static DemoService service = new DemoService();
	
	static
	{
		System.out.println("in flashcard controller");
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces="application.json")
	public FlashCard getById(@PathVariable int id)
	{
		return service.getById(id);
	}
}