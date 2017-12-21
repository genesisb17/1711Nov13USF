package com.ex.data.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.data.domain.FlashCard;
import com.ex.data.service.FlashCardService;

public class Main {

	/*
	 * INTRO TO SPRING DATA
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		FlashCardService fcService = (FlashCardService) context.getBean(FlashCardService.class);
		fcService.addFlashCard(new  FlashCard("What is Spring Data?", "its ya boy"));
	}

}
