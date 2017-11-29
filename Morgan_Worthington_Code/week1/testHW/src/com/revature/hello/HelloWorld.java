package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	//this is a comment
	
	//Below is a main method
	public static void main(String[] args) {
	
		String name = "Genesis Bonds";
		System.out.println(name);
		
		//primitive type
		int x=5;
		//Wrapper class type
		Integer ex=new Integer(5);
		//autoboxing from primitive to Wrapper Object
		ex=x;
		//Can now call methods on ex
		ex.byteValue();
		
		Scanner scan=new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello "+text);
		
		int var[][]=new int[2][3];
		var[0][2]=5;
		var[1][1]=10;
		
		System.out.println(var[0][0]);
	}
	
	/*
	 * This is a block comment aka multi-line comment
	 */
	
}
