package com.ex.beans;

import javax.persistence.*;

@Entity
@Table(name="HIP_COURSES")
public class Course {
	
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="COURSE_ID_SEQ", sequenceName="COURSE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COURSE_ID_SEQ")
	private int id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTOR_ID")
	private Instructor instructor;
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course(int id, String name, Instructor instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

	public Course(String name, Instructor instructor) {
		super();
		this.name = name;
		this.instructor = instructor;
	}

	public Course() {
		super();
	}

}
