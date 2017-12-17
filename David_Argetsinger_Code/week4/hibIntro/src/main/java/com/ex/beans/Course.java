package com.ex.beans;

import javax.persistence.*;

@Entity
@Table(name="HIP_COURSES")
public class Course {
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="C_ID_SEQ",sequenceName="C_ID_SEQ")
	@GeneratedValue(generator="C_ID_SEQ",strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="COURSE_NAME",nullable = false)
	private String name;
	
	
	// multiplicity in hibernate 
	//
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)//lazy waits until needed 
	//many course t oone instructor  don't do one to many 
	@JoinColumn(name="INSTRUCTOR_ID", nullable=false )
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
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + "]";
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
