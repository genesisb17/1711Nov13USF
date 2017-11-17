package com.revature.day2;

public class UnderstandingConstructors {
	
	int x;
	int y;
	int a,b;
	
	public UnderstandingConstructors(){
		//implicitly calls super();
		x=0;
		y=10;
		a=b=5;
	}
	
	public UnderstandingConstructors(int x){
		this.x = x;
		System.out.println("in x constructor");
	}
	
	public UnderstandingConstructors(int x, int y){
		this(10);
		this.y = y;
		System.out.println("in x y Constructor");
		
	}
	
	public UnderstandingConstructors(String str, int x){
		
	}
	
	public UnderstandingConstructors(String x, String str){
		
	}

}
