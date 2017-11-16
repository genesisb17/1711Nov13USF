package com.revature.strings;

public class MyConstructor {

	int x;
	int y;
	int a, b;
	
	public MyConstructor(){
		//implicitly calls super()
		x = 0;
		y = 10;
		a = b = 5;
		
	}
	
	public MyConstructor(int x, int y) {
		
	this.x = x;	
		
	}
	
	
	public MyConstructor(char a, char b, char c) {
		
	}
	
	public MyConstructor(boolean blah, long num, float stuff) {
		
	}
}
