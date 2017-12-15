package com.ex.beans;

import javax.persistence.CascadeType;
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

@Entity
@Table(name="HIP_COURSES")
public class Course {
	
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="COURSE_ID_SEQ", sequenceName="COURSE_ID_SEQ")
	@GeneratedValue(generator="COURSE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="COURSE_NAME", nullable=false)
	private String name;
	
	/*
	 * HERE YE:
	 * Below we have our introduction to multiplicity in Hibernate
	 */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTOR_ID")
	private Instructor instructor;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String name, Instructor instructor) {
		super();
		this.name = name;
		this.instructor = instructor;
	}

	public Course(int id, String name, Instructor instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}

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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + "]";
	}
}
