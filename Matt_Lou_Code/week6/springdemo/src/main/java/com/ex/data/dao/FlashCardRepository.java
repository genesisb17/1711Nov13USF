package com.ex.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.data.domain.FlashCard;

/*
 * this is our DAO
 */
@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {
	
	public FlashCard findFlashCardByQuestion(String question);
	
	
}
