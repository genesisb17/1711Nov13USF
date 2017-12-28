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

	/**
	 * 
	 */
	private static final long serialVersionUID = -6420326507939657071L;

	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(allocationSize=1,name="caveSeq",sequenceName="CAVE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="caveSeq")
	private int id;
	
	@Column(name="CAVE")
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


	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}
	
	
}



