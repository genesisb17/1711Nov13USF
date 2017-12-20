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
public class Course 
{
	@Id
	@Column(name="COURSE_ID")
	@SequenceGenerator(name="C_ID_SEQ",sequenceName="C_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="C_ID_SEQ")
	private int id;
	private String name;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn
	/*
	 * a fetching strategy lazy/eager is the strategy that hibernate will use for 
	 * retrieving associated ojects if the app
	 * needs to naviage the association. Fetch strategies may
	 * be declared in the ORM metadata, or overfidden by an Hql
	 * or Criteria query.
	 */
	private Instructor instructor;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
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
	
		this.name = name;
		this.instructor = instructor;
	}
	public Course() {}
	
}
