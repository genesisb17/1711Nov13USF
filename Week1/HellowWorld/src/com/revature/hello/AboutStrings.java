package com.revature.hello;

public class AboutStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello";
		String b = "Hello";
		String c = new String("hello");
		String d =a;
		
		
/*		System.out.println("1 " + a.equals(c));
		System.out.println("2 " + (a==c));
		System.out.println("3 " + a.equalsIgnoreCase(d));
		System.out.println("4 " + (a==d));
		System.out.println("5 " + a.equalsIgnoreCase(b));*/
		test(a);
		//a = test(a); 
		System.out.println(a);
		
	}

	static void test(String x) {
		x.substring(2);
	}
}
