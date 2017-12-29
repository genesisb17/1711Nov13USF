package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.FlashCard;


@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {
//simmilar to dao we using jpa here son :<https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
	public FlashCard findFlashCardByQuestion(String question);
	
	
}