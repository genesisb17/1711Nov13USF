package com.ex.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Cave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(allocationSize=1, name="C_SEQ", sequenceName="C_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="C_SEQ")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;
	
	public Cave() {}

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

	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

}
