package com.boot.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.springboot.model.FlashCard;

public interface FlashCardService {
	
	public void addFlashCard(FlashCard fc);
	public List<FlashCard> findAllFlashCards();
	public FlashCard findFlashCardByQuestion(String question);
}
