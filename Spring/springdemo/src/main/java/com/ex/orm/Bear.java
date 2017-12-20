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
@Table(name="BEARS")
public class Bear implements Serializable{

	private static final long serialVersionUID = -6062750562012564188L;
	
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(name="B_SEQ", sequenceName="B_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_SEQ")
	private int id;
	
	@Column(name="BEAR_NAME", nullable=false)
	private String name;
	
	@Column(name="BEAR_COLOR")
	private String color;

	public Bear() {}
	
	public Bear(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
	
	
	
	
	
	
	

}
