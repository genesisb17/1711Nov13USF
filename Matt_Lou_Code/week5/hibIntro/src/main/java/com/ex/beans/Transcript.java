package com.ex.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIP_TRANSCRIPTS")
public class Transcript {
		
	@Id
	@Column(name="T_ID")
	@SequenceGenerator(name="T_ID_SEQ", sequenceName="T_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_ID_SEQ")
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="TRANSCRIPT_COURSES",
	joinColumns=@JoinColumn(name="T_ID"),
	inverseJoinColumns=@JoinColumn(name="C_ID"))
	private Set<Course> courses;
	
	public Transcript() {}
	
	public Transcript(int id, Set<Course> courses) {
		super();
		this.id = id;
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Transcript [id=" + id + ", courses=" + courses + "]";
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
	
	
	
}
