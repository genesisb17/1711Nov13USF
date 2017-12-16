package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HIP_INSTRUCTORS")
public class Instructor 
{
	@Id
	@Column(name="INSTRUCTOR_ID")
	@SequenceGenerator(name="INST_ID_SEQ",sequenceName="INST_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="INST_ID_SEQ")
	private int id;
	
	@Column(name="INSTRUCTOR_NAME",nullable=false)
	private String name;
	public Instructor() {}
	public Instructor(String name) 
	{
		this.name = name;
	}
	public Instructor(int id, String name) 
	{
		super();
		this.id = id;
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + "]";
	}
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
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
