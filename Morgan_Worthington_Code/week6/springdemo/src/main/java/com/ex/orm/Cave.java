package com.ex.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CAVE")
public class Cave {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="caveSeq")
	@SequenceGenerator(allocationSize=1,name="caveSeq",sequenceName="CAVE_SEQ")
	@Column(name="CAVE_ID")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;
	
	public Cave() {}
	
	public Cave(int id, String name) {
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
