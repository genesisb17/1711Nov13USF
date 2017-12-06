package com.revature.Andy;

public class UnderstandConstructors {

	int num1;
	int num2;
	String name;
	
	public UnderstandConstructors() {
		num1 = 1;
		num2 = 2;
		name = "TBD";
	}
	
	public UnderstandConstructors(int x) {
		this.num1 = x;
	}
	
	public UnderstandConstructors(int x, int y) {
		this(x);
		this.num1 = y;
	}
	
	public UnderstandConstructors(String str, int x) {
		
	}
	
	public UnderstandConstructors(int x, String str) {
		
	}

	public UnderstandConstructors(int num1, int num2, String name) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.name = name;
	}
	
}
