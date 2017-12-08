package com.ex.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIP_TRANSCRIPTS")
public class Transcript {

	@Id()
	@Column(name="T_ID")
	@SequenceGenerator(name="T_ID_SEQ", sequenceName="T_ID_SEQ")
	@GeneratedValue(generator="T_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_COURSES",
	joinColumns=@JoinColumn(name="T_ID"),
	inverseJoinColumns=@JoinColumn(name="C_ID"))
	private Set<Course> courses;

	public Transcript() {
		
	}
	
	public Transcript(int id, Set<Course> courses, Course course) {
		super();
		this.id = id;
		this.courses = courses;
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
	
}
