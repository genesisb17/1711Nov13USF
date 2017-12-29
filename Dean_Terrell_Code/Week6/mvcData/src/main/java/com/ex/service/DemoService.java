package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.domain.FlashCard;


public class DemoService {
	
	private int count = 1;
	static ArrayList<FlashCard> cards;
	static {
		cards = new ArrayList();
		cards.add(new FlashCard(1, "test", "answer"));
		cards.add(new FlashCard(2, "a question", "an answer"));
		cards.add(new FlashCard(3, "what is 2+2?", "minus 1 that's 3 quick maffs"));
	}
	
	public List<FlashCard> getAll() {
		return cards;
	}
	
	public FlashCard getById(int id) {
		for(FlashCard fc : cards)
			if(fc.getId() == id)
				return fc;
		return null;
	}
	public FlashCard addCard(FlashCard fc) {
		fc.setId(++count);
		cards.add(fc);
		return fc;
	}
	public FlashCard update(FlashCard fc) {
		int id = fc.getId();
		FlashCard old = getById(id);
		if(old == null) return null;
		old.setQuestion(fc.getQuestion());
		old.setAnswer(fc.getAnswer());
		return old;
	}
	public void delete(FlashCard fc) {
		int id = fc.getId();
		cards.remove(id);
	}
}