package com.ex.orm;

import java.io.Serializable;

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
public class Cave implements Serializable {

	private static final long serialVersionUID = -1755527310387394829L;

	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(allocationSize=1, name="CAVE_ID_SEQ", sequenceName="CAVE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAVE_ID_SEQ")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;

	public Cave() {
		super();
	}

	public Cave(String name) {
		super();
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}

}
