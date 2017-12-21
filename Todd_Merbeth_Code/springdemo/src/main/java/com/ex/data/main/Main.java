package com.ex.data.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.data.domain.FlashCard;
import com.ex.data.service.FlashCardService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		FlashCardService fcService = (FlashCardService) context.getBean("flashCardServiceImpl");
		
		fcService.addFlashCard(new FlashCard("What is Spring data?", "Awesome"));
	}
}
