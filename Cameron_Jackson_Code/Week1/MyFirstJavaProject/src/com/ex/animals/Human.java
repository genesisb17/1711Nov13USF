package com.ex.animals;

public class Human extends Animal {

	private int age;
	private String hairColor;
	private double height;
	
	public Human() {}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public int reproduce(int numPartiesInvolved) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int perish(double timeToLive) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String waste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String move(String moveLike) {
		return moveLike;
	}

	@Override
	void speak(String speaksLike) {
		// TODO Auto-generated method stub
		
	}
	
}
