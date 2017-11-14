package com.ex.animals;

public class Human extends Animal{

	private int age;
	private String hairColor;
	private double height;
	
	public Human(){
		
	}
	
	@Override
	public int reproduce(int numPartiesInloved) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consume(String... substance) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return null;
	}

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
}
