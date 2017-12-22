package com.boot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.springboot.model.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {
	
	public FlashCard findFlashCardByQuestion(String question);

}
