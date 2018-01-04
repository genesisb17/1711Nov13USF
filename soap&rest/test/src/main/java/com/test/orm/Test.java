package com.test.orm;

public class Test {
	
	public static void main(String[] args) {
		dao dao = new dao();
		Hello hello = new Hello();
		hello.setText("testing");
		dao.addText(hello);
	}

}
