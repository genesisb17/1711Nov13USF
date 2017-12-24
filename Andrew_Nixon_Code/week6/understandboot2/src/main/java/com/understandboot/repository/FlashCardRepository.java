package com.understandboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.understandboot.model.FlashCard;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {
	
	public FlashCard findFlashCardByQuestion(String question);

}
