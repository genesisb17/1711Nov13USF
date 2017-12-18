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


@NamedQueries({
	@NamedQuery(
			name = "findInstructorByIdHHQL",
			query = "from Instructor i where i.id = :id"
			),
	@NamedQuery(
			name = "findInstructorByNameHHQL",
			query = "from Instructor i where name like :name"
			),
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "findInstructorByIdHHQL",
			query = "select * from instructors where i where inst_id = :id"
			),
	@NamedNativeQuery(
			name = "findInstructorByNameHHQL",
			query = "select * from instructors where instructor_name like :name"
	)
})

@Entity
@Table(name = "HIP_INSTRUCTORS")
public class Instructor {
	
	@Id
	@Column(name = "INSTRUCTORS_ID")
	@SequenceGenerator(name = "INST_ID_SEQ", sequenceName = "INST_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INST_ID_SEQ")
	private int id;
	
	@Column(name = "INSTRUCTOR_NAME", nullable = false)
	private String name;
	
	public Instructor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Instructor(String name) {
		this.name = name;
	}
	
	public Instructor() {}

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

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + "]";
	}
	
}
