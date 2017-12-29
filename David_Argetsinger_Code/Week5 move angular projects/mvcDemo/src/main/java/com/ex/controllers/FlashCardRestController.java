package com.ex.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/flashcard")
public class FlashCardRestController {
	static DemoService service= new DemoService();
	
	static ApplicationContext context = 
			new ClassPathXmlApplicationContext("beans.xml");
	
	static FlashCardService fcService 
	= (FlashCardService) context.getBean("flashCardServiceImpl");
	
	
	
	//@RequestMapping(value="/{id}", method= RequestMethod.GET, produces="application/json")
	@RequestMapping(value="/{id}",  method = RequestMethod.GET,  produces = "application/json")
	
	public FlashCard getById(@PathVariable int id){
		System.out.println("eyyyyy");
		return service.getById(id);
		
	}
	
	@RequestMapping( 
			  method = RequestMethod.GET, 
			  produces = "application/json"
			)
	
	public List<FlashCard> getAll(){
		System.out.println("eyyyyy000");
		//return service.getAll();
//		return fcService.findAllFlashCards();
		return service.getAll();
		
	}
	@RequestMapping(method=RequestMethod.POST,consumes="application/json", produces="application/json")
	public FlashCard  addFC(@RequestBody FlashCard fc){
		//fc=service.addCard(fc);
		fc=service.addCard(fc);
	    return fc;
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ResponseEntity<FlashCard> updateFc(@RequestBody FlashCard fc){
		FlashCard card=service.update(fc);
		if(card==null) return new ResponseEntity<FlashCard>(HttpStatus.NOT_FOUND);
		else {return  new ResponseEntity<FlashCard>(card, HttpStatus.OK);}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<FlashCard> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<FlashCard>( HttpStatus.OK);
	}
	
//	@RequestMapping(value="/{id}",method=RequestMethod.DELETE, consumes="application/json")
//	public void deleteFc(@PathVariable int id){
//		service.delete(id);
//	}
}
