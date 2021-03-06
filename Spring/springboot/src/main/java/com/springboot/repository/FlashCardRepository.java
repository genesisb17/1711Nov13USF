package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.FlashCard;


@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {

	public FlashCard findFlashCardByQuestion(String question);
	
}
