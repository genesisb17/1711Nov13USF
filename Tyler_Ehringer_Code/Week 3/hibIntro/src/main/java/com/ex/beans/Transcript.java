package com.ex.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIP_TRANSCRIPTS")
public class Transcript {

	public Transcript(Set<Course> courses) {
		super();
		this.courses = courses;
	}

	public Transcript() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Transcript [id=" + id + ", courses=" + courses + "]";
	}

	@Id
	@Column(name = "TRANSCRIPT_ID")
	@SequenceGenerator(name = "TRANSCRIPT_ID_SEQ", sequenceName = "TRANSCRIPT_ID_SEQ")
	@GeneratedValue(generator = "TRANSCRIPT_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;

	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TRANSCRIPT_COURSE", 
		joinColumns = { @JoinColumn(name = "TRANSCRIPT_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set<Course> courses;
	

}
