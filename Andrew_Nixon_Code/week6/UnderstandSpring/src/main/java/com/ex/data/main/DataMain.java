package com.ex.data.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.data.domain.FlashCard;
import com.ex.data.service.FlashCardService;

public class DataMain {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		FlashCardService fcService = (FlashCardService) ac.getBean("flashCardServiceImp");
		
		fcService.addFlashCard(new FlashCard("What is Spring data?", "Awesome."));

	}

}
