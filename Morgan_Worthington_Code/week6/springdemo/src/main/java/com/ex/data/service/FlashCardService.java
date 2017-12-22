package com.ex.data.service;

import java.util.List;

import com.ex.data.domain.FlashCard;

public interface FlashCardService {
	
	public void addFlashCard(FlashCard fc);
	public List<FlashCard> findAllFlashCards();
	public FlashCard findFlashCardByQuestion(String question);
	
}
