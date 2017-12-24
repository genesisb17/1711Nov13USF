package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.domain.FlashCard;

public class DemoService {
	
	static ArrayList<FlashCard> flashCards;
	static int count;
	static {
		flashCards = new ArrayList();
		flashCards.add( new FlashCard(1, "test?", "answer"));
		flashCards.add( new FlashCard(2, "Understand?", "no"));
		flashCards.add( new FlashCard(3, "Why?", "because"));
		flashCards.add( new FlashCard(4, "can you?", "yes"));
		flashCards.add( new FlashCard(5, "...may you?", "very well"));
		count = 5;
	}
	
	public List<FlashCard> getAll() {
		return flashCards;
	}
	
	public FlashCard getById(int id) {
		for (FlashCard flashCard : flashCards) {
			if (flashCard.getId() == id) {
				return flashCard;
			}
		}
		return null;
	}
	
	public FlashCard add(FlashCard flashCard) {
		flashCard.setId(++count); 
		flashCards.add(flashCard);
		return flashCard;
	}
	
	public FlashCard update(FlashCard flashCard) {
		int id = flashCard.getId();
		FlashCard old = getById(id);
		if(old == null) {return null;}
		old.setQuestion(flashCard.getQuestion());
		old.setAnswer(flashCard.getAnswer());
		return old;
	}

}
