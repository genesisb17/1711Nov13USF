package com.revature.hello;

public class AboutStrings {

	public static void main(String[] args){
		String a="hello";
		String b="Hello";
		String c=new String("hello");
		String d=a;
		String e="hello";
		
/*		System.out.println("1 "+a.equals(c));
		System.out.println("2 "+(a==c));
		System.out.println("3 "+ (a.equals(e)));
		System.out.println("4 "+(a==e));
		System.out.println("5 "+a.equalsIgnoreCase(b));*/
		
		//test(a);
		//a=test(a);
		System.out.println(test(a));
	}
	static String test(String x){
		return x.substring(2);
	}
}
