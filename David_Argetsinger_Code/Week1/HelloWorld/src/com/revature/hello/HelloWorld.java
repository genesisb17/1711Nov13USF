package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	//this is a comment
	//below is a main method 
	public static void main(String[] args) {
		String name ="Genesis Bonds";
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5); //wrapper class 
		ex = x; //autoboxing (primitive)
		
		Scanner scan = new Scanner(System.in); //ctrl+shift+o consolidate imports 
		String text = scan.nextLine();
		System.out.println("hello "+ text);
		int var[][]= new int[2][3];
		var[0][2]=5;
		var[1][1]=10;
		System.out.println(var[0][0]);
		
		}
	}
	/*
	 * block comment
	 */

