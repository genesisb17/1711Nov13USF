package com.revature.day2;

public class ConstructorDemo {

	int x;
	int y;
	int a, b;

	

	// ConstructorDemo cd = new ConstructorDemo();
	public ConstructorDemo() {
		// implicitly calls super();
		System.out.println("in no-args constructor");
	}
	

	public ConstructorDemo(int x) {
		this.x = x;
		System.out.println("in x ConstructorDemo");
	}

	public ConstructorDemo(int y, int a, int b) {
		this(10);
		this.y = y;
		this.a = a;
		this.b = b;
		System.out.println("in y a b ConstructorDemo");
	}

	public ConstructorDemo(int x, int y, int a, int b) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
}
