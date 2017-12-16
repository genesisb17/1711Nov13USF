package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * Named Queries
 * Hard to maintain and ugly. Avoid, but here's what named queries are.
 * This can be done via XML or annotations. Below is how it works with annotations.
 * For further research/info on how it works in your Hibernate mapping file, check out:
 * http://www.mykong.com/hibernate/hibernate-named-query-examples/
 * 
 * Check HibDAO for how these are called
 */
//in HQL
@NamedQueries({
	@NamedQuery(
			name="findInstructorByIdHQL",
			query="from Instructor i where i.id= :id"
			),
	@NamedQuery(
			name="findInstructorByNameHQL",
			query="from instructor i where name like :name"
			)
})

//in native SQL
@NamedNativeQueries({
	@NamedNativeQuery(
			name="findInstructorByIdSQL",
			query="select * from instructors where inst_id = :id"),
	@NamedNativeQuery(
			name="findInstructorsByNameSQL",
			query="select * from instructors where instructor_name like :name"
			)
})

@Entity
@Table(name="HIP_INSTRUCTORS")
public class Instructor {
	
	@Id
	@Column(name="INSTRUCTOR_ID")
	@SequenceGenerator(name="INST_ID_SEQ",sequenceName="INST_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="INST_ID_SEQ")
	private int id;
	
	@Column(name="INSTRUCTOR_NAME", nullable=false)
	private String name;
	
	public Instructor() {}
	public Instructor(String name) {
		this.name=name;
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
