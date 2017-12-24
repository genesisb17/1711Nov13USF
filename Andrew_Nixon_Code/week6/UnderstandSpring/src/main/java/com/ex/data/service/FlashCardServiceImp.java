package com.ex.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.data.dao.FlashCardRepository;
import com.ex.data.domain.FlashCard;

@Service
@Transactional
public class FlashCardServiceImp implements FlashCardService{
	
	@Autowired
	private FlashCardRepository fcr;

	@Override
	public void addFlashCard(FlashCard fc) {
		fcr.save(fc);
	}

	@Override
	public List<FlashCard> findAllFlashCards() {
		return fcr.findAll();
	}

	@Override
	public FlashCard findFlashCardByQuestion(String question) {
		return fcr.findFlashCardByQuestion(question);
	}

	@Override
	public FlashCard findFlashCardByAnswer(String answer) {
		return fcr.findFlashCardByAnswer(answer);
	}
}
