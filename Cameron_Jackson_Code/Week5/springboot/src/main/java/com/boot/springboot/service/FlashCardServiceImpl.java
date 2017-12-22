package com.boot.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.springboot.model.FlashCard;
import com.boot.springboot.repository.FlashCardRepository;

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
