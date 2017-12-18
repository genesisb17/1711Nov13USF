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
	
	@Column(name="COURSE_NAME")
	private String name;
	
	/*
	 * HERE YE:
	 * Below we have our introduction to multiplicity in Hibernate
	 * A fetching strategy (LAZY of EAGER) is the strategy that Hibernate 
	 * will use for retrieving associated objects if the app needs to
	 * navigate the association. Fetch strategies may be declared in
	 * the ORM metadata, or overridden by an HQL or Criteria query.
	 * 
	 * The cascade keyword often appears on the collection mapping to 
	 * manage the state of the collection of dependencies automatically.
	 */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)    // Eager will immediately loaded from the database, Lazy will load it when needed
	@JoinColumn(name="INSTRUCTOR_ID")							  // Can rename
	private Instructor instructor;

	public Course() {}
	
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