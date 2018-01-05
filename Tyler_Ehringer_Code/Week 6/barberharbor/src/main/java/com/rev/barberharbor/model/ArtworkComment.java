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
@Table(name="ARTWORK_COMMENTS")
public class ArtworkComment implements Serializable{

	private static final long serialVersionUID = 8221187156596917866L;
	
	@Id
	@Column(name="ARTOWRK_COMMENTS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="A_C_SEQ", sequenceName="A_C_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="A_C_SEQ")
	private Long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ARTWORK_ID")
	private Artwork artwork;
	
	@Column(name="COMMENT")
	private String comment;

	public ArtworkComment() {
		super();
	}

	public ArtworkComment(Artwork artwork, String comment) {
		super();
		this.artwork = artwork;
		this.comment = comment;
	}

	public ArtworkComment(Long id, Artwork artwork, String comment) {
		super();
		this.id = id;
		this.artwork = artwork;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}
