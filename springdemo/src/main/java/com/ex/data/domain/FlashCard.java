package com.ex.data.domain;

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
public class FlashCard 
{
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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public FlashCard(String question) {
		super();
		this.question = question;
	}

}
