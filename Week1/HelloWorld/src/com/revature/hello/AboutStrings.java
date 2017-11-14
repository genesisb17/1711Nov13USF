package com.revature.hello;

public class AboutStrings {

	public static void main(String[] args) {
		
		String c = "hello";
		String b = "Hello";
		String a = new String("hello");
		String d = a;
		String e = "hello";
		
/*		System.out.println("1 " + a.equals(c));
		System.out.println("2 " + (a==c));
		System.out.println("3 " + c.equals(e));
		System.out.println("4 " + (c==e));
		System.out.println("5 " + a.equalsIgnoreCase(b));*/

		test(a);
		//a = test( a);
		System.out.println(a);
		
	}
	
	
	 static void test(String x){
		 x.substring(2);
	 }
	

}
