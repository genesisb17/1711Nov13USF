package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTORS")
public class Instructor {

	@Id
	@Column(name="INSTRUCTOR_ID")
	@SequenceGenerator(name = "INSTRUCTOR_ID_SEQ", sequenceName = "INSTRUCTOR_ID_SEQ")
	@GeneratedValue(generator = "INSTRUCTOR_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="INSTRUCTOR_NAME", nullable=false)
	private String name;
	
	
	public Instructor() {};
	
	public Instructor(String name) {
		this.name = name;
	}
	public Instructor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}