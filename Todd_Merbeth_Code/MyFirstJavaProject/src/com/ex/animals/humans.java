package com.ex.animals;

public class humans extends Animal{

	private int age;
	private String haircolor;
	private double height;
	
	public void human() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHaircolor() {
		return haircolor;
	}

	public void setHaircolor(String haircolor) {
		this.haircolor = haircolor;
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
	public void consume(String... substance) {
		// TODO Auto-generated method stub
		
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
	
	// This is a method override
	public String move(String moveLike) {
		
		return moveLike;
	}

	@Override
	void speak(String speakslike) {
		// TODO Auto-generated method stub
		
	}

}
