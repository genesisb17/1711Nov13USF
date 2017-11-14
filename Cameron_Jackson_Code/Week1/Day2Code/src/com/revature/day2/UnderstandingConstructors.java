package com.revature.day2;

public class UnderstandingConstructors {
	
	int val;
	String str;
	char c;
	
	public UnderstandingConstructors() {}
	
	public UnderstandingConstructors(int x) {
		this.val = x;
	}
	
	public UnderstandingConstructors(int x, String y) {
		this(x);
		this.str = y;
	}
	
	public UnderstandingConstructors(int x, String y, char z) {
		this(x,y);
		this.c = z;
	}
}
