package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ex.domain.FlashCard;

public class DemoService {
	
	static ArrayList<FlashCard> cards;
	static int count;
	static {
		cards = new ArrayList<FlashCard>();
		cards.add(new FlashCard(1, "How far?", "12 feet"));
		cards.add(new FlashCard(2, "How tall?", "3"));
		cards.add(new FlashCard(3, "How heavy?", "9 pounds"));
		count = 4;
	}
	
	public FlashCard getById(int id) {
		for(FlashCard f : cards) {
			if(f.getId() == id) return f;
		}
		return null;
	}
	
	public List<FlashCard> getAll(){
		return cards;
	}
	
	public FlashCard addCard(FlashCard f) {
		f.setId(count++);
		cards.add(f);
		return f;
	}
	
	public boolean deleteFlashCard(int id) {
		return cards.removeIf(f -> f.getId() == id);
	}

}
