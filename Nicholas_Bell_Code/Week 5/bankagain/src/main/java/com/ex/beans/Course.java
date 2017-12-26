package com.ex.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIP_COURSES")
public class Course {
	
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name = "COURSE_ID_SEQ", sequenceName="COURSE_ID_SEQ")
	@GeneratedValue(generator="COURSE_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="COURSE_NAME", nullable = false)
	private String name;
	
	
	/*
	 * INTRO TO MULTIPLICITY
	 * 
	 * A fetching strategy is the strategy that HIB will use for retrieving associated
	 *  objects. if the app needs to navigate te association. fetc strats may be declared in the orm metadata
	 *  or overridden by an hql or criteria query
	 *  
	 *  
	 */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTOR_ID")
	private Instructor teacher; 
	
	
	
	public Course() {}
	
	public Course(int id, String name, Instructor teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	
	public Course(String name, Instructor teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
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
	public Instructor getTeacher() {
		return teacher;
	}
	public void setTeacher(Instructor teacher) {
		this.teacher = teacher;
	}
	
	

}
