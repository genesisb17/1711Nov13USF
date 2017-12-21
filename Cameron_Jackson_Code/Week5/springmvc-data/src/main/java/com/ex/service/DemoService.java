package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.domain.FlashCard;

public class DemoService {
	
	static ArrayList<FlashCard> cards; 
	static int count;
	static {
		cards = new ArrayList<FlashCard>();
		cards.add(new FlashCard(1, "test", "answer"));
		cards.add(new FlashCard(2, "sup?", "the sky."));
		cards.add(new FlashCard(3, "but why?", "because."));
		cards.add(new FlashCard(4, "yes?", "no."));
		count = 4;
	}

	public List<FlashCard> getAll() {
		return cards;
	}
	
	public FlashCard getCardById(Integer id) {
		for (FlashCard fc: cards) {
			if (fc.getId().equals(id))
				return fc;
		}
		return null;
	}
	
	public FlashCard addCard(FlashCard card) {
		card.setId(++count);
		cards.add(card);
		return card;
	}
	
	public FlashCard updateCard(FlashCard card) {
		Integer id = card.getId();
		FlashCard old = getCardById(id);
		if(old == null) {return null;}
		old.setQuestion(card.getQuestion());
		old.setAnswer(card.getAnswer());
		return old;
	}
	
	public FlashCard deleteCard(Integer id) {
		FlashCard fc = getCardById(id);
		FlashCard newFc = new FlashCard(fc.getId(), fc.getQuestion(), fc.getAnswer());
		cards.removeIf(card -> card.getId().equals(id));
		return fc;
	}
}
