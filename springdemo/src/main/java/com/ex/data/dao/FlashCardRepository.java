package com.ex.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.data.domain.FlashCard;

public interface FlashCardRepository extends JpaRepository<flashCard,Integer>
{
	public FlashCard findFlashCardByQuestion(string question);
}
