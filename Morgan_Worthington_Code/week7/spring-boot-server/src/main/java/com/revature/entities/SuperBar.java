package com.revature.entities;

import java.util.ArrayList;

public class SuperBar {
	private String name;
	private int id;
	private String power;
	private int rating;
	
	
	public SuperBar(String name, int id, String power, int rating) {
		super();
		this.name = name;
		this.id = id;
		this.power = power;
		this.rating = rating;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

}
