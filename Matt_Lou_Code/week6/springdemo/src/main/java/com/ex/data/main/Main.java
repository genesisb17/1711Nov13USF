package com.ex.data.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.data.domain.FlashCard;
import com.ex.data.service.FlashCardService;

public class Main {
	/*
	 * INTRO TO SPRING DATA
	 * -Spring data is the highest level of ORM
	 * we will cover. This framework removes
	 * the DAO implementations entirely. The only
	 * artifact that needs to be explicitly defined is
	 * the DAO Interface
	 */
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		FlashCardService fcService 
			= (FlashCardService) context.getBean("flashCardServiceImpl");
		
		fcService.addFlashCard(new FlashCard("What is Springs data?", "Awesomeness"));
		
	}
	
}
