package com.rev.barberharbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BARBER_REVIEWS")
public class BarberReview implements Serializable {

	private static final long serialVersionUID = 4891726448236074939L;

	@Id
	@Column(name="BARBER_REVIEWS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="B_R_SEQ", sequenceName="B_R_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_R_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BARBER_ID")
	private Barber barber;
	
	@Column(name="RATING")
	private double rating;
	
	@Column(name="COMMENT")
	private String comment;

	public BarberReview() {
		super();
	}

	public BarberReview(Barber barber, double rating, String comment) {
		super();
		this.barber = barber;
		this.rating = rating;
		this.comment = comment;
	}

	public BarberReview(Long id, Barber barber, double rating, String comment) {
		super();
		this.id = id;
		this.barber = barber;
		this.rating = rating;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Barber getBarber() {
		return barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
