package com.ex.beans;

import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="HIP_TRANSCRIPTS")
public class Transcript {
	
	@Id
	@Column(name="T_ID")
	@SequenceGenerator(name="T_ID_SEQ",sequenceName="T_ID_SEQ")
	@GeneratedValue(generator="T_ID_SEQ",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSES", 
	joinColumns = { @JoinColumn(name = "T_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set<Course> courses;

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

	public Transcript() {
		super();
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

	@Override
	public String toString() {
		return "Transcript [id=" + id + ", courses=" + courses + "]";
	}

}
