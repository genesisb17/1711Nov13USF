package com.revature.hello;

public class AboutStrings {

	public static void main(String[] args) {
<<<<<<< HEAD
		String a = "hello";
		String b = "Hello";
		String c = new String("hello");
		String d = a;
		String e = "hello";
		
//		System.out.println(a.equals(c)); // .equals compares values so true
//		System.out.println(a==c); // == compares location of variable so false
//		System.out.println(a.equalsIgnoreCase(d)); // true
//		System.out.println(a==d); // true
//		System.out.println(a.equalsIgnoreCase(b)); //true
//		System.out.println(c==e); // false, e goes to the first string in the pool that matches
//		System.out.println(a==e); // true
		test(a);
//		a=test(a);
		System.out.println(a);
	}
	static String test(String x) {
		return x.substring(2);
	}
=======
		
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
	
>>>>>>> master

}
