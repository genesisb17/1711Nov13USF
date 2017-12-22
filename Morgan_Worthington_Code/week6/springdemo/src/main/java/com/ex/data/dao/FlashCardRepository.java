package com.ex.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.data.domain.FlashCard;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard,Integer> {
	public FlashCard findFlashCardByQuestion(String question);
	
}
