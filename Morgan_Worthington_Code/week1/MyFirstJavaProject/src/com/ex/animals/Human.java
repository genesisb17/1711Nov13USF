package com.ex.animals;

public class Human extends Animal {

	private int age;
	private String haircolor;
	private double height;
	
	public Human(){}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	
	public String getHairColor(){
		return haircolor;
	}
	
	public void setHairColor(String haircolor){
		this.haircolor=haircolor;
	}

	@Override
	public int reproduce(int partiesInvolved) {
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
 
}
