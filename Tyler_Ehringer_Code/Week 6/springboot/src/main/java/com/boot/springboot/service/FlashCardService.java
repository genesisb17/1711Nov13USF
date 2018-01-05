package com.boot.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.springboot.model.FlashCard;
import com.boot.springboot.repository.FlashCardRepository;

@Service
@Transactional
public class FlashCardService {
	
	@Autowired
	private FlashCardRepository fcRepo;
	
	public void addFlashCard(FlashCard fc) {
		fcRepo.save(fc);
	}
	
	public List<FlashCard> getAllFlashcards(){
		return fcRepo.findAll();
	}
	
	public FlashCard getFlashCardByQuestion(String question) {
		return fcRepo.findFlashCardByQuestion(question);
	}

}
