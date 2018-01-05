package com.ex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.domain.FlashCard;

public interface FlashCardRepository extends JpaRepository<FlashCard,Integer> {
	public FlashCard findFlashCardByQuestion(String question);
}
