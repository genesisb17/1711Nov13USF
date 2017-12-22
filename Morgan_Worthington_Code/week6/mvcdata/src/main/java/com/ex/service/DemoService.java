package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.domain.FlashCard;

public class DemoService {

	static ArrayList<FlashCard> cards;
	static int count;
	static {
		cards=new ArrayList();
		cards.add(new FlashCard(1,"test1","answer1"));
		cards.add(new FlashCard(2,"test2","answer2"));
		cards.add(new FlashCard(3,"test3","answer3"));
		cards.add(new FlashCard(4,"test4","answer4"));
		cards.add(new FlashCard(5,"test5","answer5"));
		count=5;
	}
	
	public List<FlashCard> getAll() {
		return cards;
	}
	
	public FlashCard getById(int id) {
		for(FlashCard fc:cards) {
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
	
	public FlashCard update(FlashCard fc) {
		int id=fc.getId();
		FlashCard old=getById(id);
		if(old==null) {return null;}
		old.setQuestion(fc.getQuestion());
		old.setAnswer(fc.getAnswer());
		return old;
	}
	
	public void deleteCard(int id) {
		cards.removeIf(f->id==f.getId());
	}
}
