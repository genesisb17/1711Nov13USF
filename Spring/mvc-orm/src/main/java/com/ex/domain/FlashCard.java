package com.ex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="FLASHCARDS")
public class FlashCard {
	
	@Id
	@Column(name="fc_id")
	@SequenceGenerator(allocationSize=1,name="flashcardSeq",sequenceName="FC_SEQ")
	@GeneratedValue(generator="flashcardSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="fc_question")
	private String question;
	
	@Column(name="fc_answer")
	private String answer;

	public FlashCard() {}
	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	public FlashCard(Integer id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
