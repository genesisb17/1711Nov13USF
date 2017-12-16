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
public class Transcript 
{
	@Id
	@Column(name="Transcript_ID")
	@SequenceGenerator(name="T_ID_SEQ",sequenceName="T_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="T_ID_SEQ")
	private int id;
	/**
	 * @return the id
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="TRANSCRIPTS_COURSES",
	joinColumns=@JoinColumn(name="T_ID"),
	inverseJoinColumns=@JoinColumn(name="C_ID"))
	private Set<Course> courses;

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
	 * @return the courses
	 */
	public Set<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}