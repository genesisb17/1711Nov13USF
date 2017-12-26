package com.springboot.service;

import java.util.List;

import com.springboot.model.FlashCard;

public interface FlashCardService {

	public void addFlashCard(FlashCard fc);
	public List<FlashCard> findAllFlashCards();
	public FlashCard findFlashCardByQuestion(String question);
}
