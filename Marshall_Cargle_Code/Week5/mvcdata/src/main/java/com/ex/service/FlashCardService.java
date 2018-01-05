package com.ex.service;

import java.util.List;

import com.ex.domain.FlashCard;

public interface FlashCardService {
	public void addFlashCard(FlashCard fc);
	public List<FlashCard> findAllFlashCards();
	public FlashCard findFlashCardByQuestion(String question);
}
