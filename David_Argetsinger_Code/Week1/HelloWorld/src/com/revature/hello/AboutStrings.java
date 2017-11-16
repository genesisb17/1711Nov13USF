package com.revature.hello;

import java.util.Scanner;

public class AboutStrings {

	public static void main(String[] args) {
		String hold="Yellow";
		String holw="Ready";
		
		System.out.println(hold.concat(holw.substring(3)));
		System.out.println(Character.toUpperCase((holw.charAt(3))));
		Scanner in=new Scanner(System.in);
		String text=in.nextLine().toUpperCase();
		System.out.println("type something");
		System.out.println("    "+text);
		
		System.out.println(text.trim());
		
		in.close();
		
//		String a = "hello";
//		String b="Hello";
//		String c= new String("hello");
//		String d=a;
//		String e="hello";
//		System.out.println("1 "+ a.equals(c));
//		System.out.println("2 "+(a==c));	
//		System.out.println("3 "+ a.equals(d));
//		System.out.println("4 "+(a==d));
//		System.out.println("5 "+(a.equalsIgnoreCase(b)));
//		//== compares location don't use on objects!!
//		System.out.println("6 "+ a.equals(e));
//		System.out.println("4 "+(a==e));
//		
//		test(a);
//		System.out.println(a);
	}
	static void test(String x)
	{
		x.substring(2);
	}
	
}
