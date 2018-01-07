package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.FlashCard;
import com.springboot.repository.FlashCardRepository;


@Service
@Transactional
public class FlashCardServiceImpl implements FlashCardService {

	@Autowired
	private FlashCardRepository fcRepo;
	
	public void addFlashCard(FlashCard fc) {
		fcRepo.save(fc);
	}

	public List<FlashCard> findAllFlashCards() {
		return fcRepo.findAll();
	}

	public FlashCard findFlashCardByQuestion(String question) {
		return fcRepo.findFlashCardByQuestion(question);
		
	}

}
