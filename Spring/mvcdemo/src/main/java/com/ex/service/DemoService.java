package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.domain.FlashCard;

public class DemoService {
	
	static ArrayList<FlashCard> cards;
	static int count;
	static {
		cards = new ArrayList();
		cards.add(new FlashCard(1, "test", "answer"));
		cards.add(new FlashCard(2, "genesis", "is awesome"));
		cards.add(new FlashCard(3, "what is spring", "thanks for asking"));
		cards.add(new FlashCard(4, "what's for dinner?","steak"));
		cards.add(new FlashCard(5, "test2", "answer2"));
		count = 5;
	}
	
	public List<FlashCard> getAll() {
		return cards;
	}
	
	public FlashCard getById(int id) {
		for(FlashCard fc : cards) {
			if(fc.getId()==id) {
				return fc;
			}
		}
		return null;
	}
	
	public FlashCard addCard(FlashCard fc) {
		fc.setId(++count);
		cards.add(fc);
		return fc;
	}

}
