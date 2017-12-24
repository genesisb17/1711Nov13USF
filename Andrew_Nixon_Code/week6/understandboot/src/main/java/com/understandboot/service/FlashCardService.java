package com.understandboot.service;

import java.util.List;

import com.understandboot.model.FlashCard;


public interface FlashCardService {
	
	public void addFlashCard(FlashCard fc);
	public List<FlashCard> findAllFlashCards();
	public FlashCard findFlashCardByQuestion(String question);

}
