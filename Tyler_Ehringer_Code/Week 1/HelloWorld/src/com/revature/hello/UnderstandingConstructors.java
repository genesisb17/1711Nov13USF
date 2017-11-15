package com.revature.hello;

public class UnderstandingConstructors {
	
	static int x;
	
	public UnderstandingConstructors() {
		System.out.println("help me");
	}
	
	public UnderstandingConstructors(int a) {
		System.out.println(a);
	}
	
	public UnderstandingConstructors(Object a) {
		System.out.println(a.toString());
	}
	
	public static void main(String[] args) {
		UnderstandingConstructors a = new UnderstandingConstructors();
		a.x = 3;
		System.out.println(a.x);
	}

}

