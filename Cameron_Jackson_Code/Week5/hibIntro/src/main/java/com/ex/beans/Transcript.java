package com.ex.beans;

import java.util.Set;

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
@Table(name="HIP_TRANSCRIPT")
public class Transcript {

	@Id
	@Column(name="TRANSCRIPT_ID")
	@SequenceGenerator(name="TRANSCRIPT_ID_SEQ", sequenceName="TRANSCRIPT_ID_SEQ")
	@GeneratedValue(generator="TRANSCRIPT_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSES", 
	joinColumns=@JoinColumn(name="TRANSCRIPT_ID"),
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private Set<Course> courses;

	public Transcript() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transcript(Set<Course> courses) {
		super();
		this.courses = courses;
	}

	public Transcript(int id, Set<Course> courses) {
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
