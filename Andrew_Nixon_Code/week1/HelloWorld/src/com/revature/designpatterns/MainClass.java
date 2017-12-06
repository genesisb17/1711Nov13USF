package com.revature.designpatterns;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * Singleton must use the getInstance() method to instantiate
		 */
		
		Singleton single = Singleton.getInstance();
		System.out.println(single.count);
		
		Singleton another = Singleton.getInstance();
		another.count++;
		System.out.println(single.count);
		
		/*
		 * FACTORY DESIGN PATTERN
		 * a way to create an object without exposing creation logic to client. we refer 
		 * to the newly created object using a common interface
		 */
		
		ToolFactory factory= new ToolFactory();
		Scanner scan = new Scanner(System.in);
		System.out.println("choose a tool");
		String tool = scan.nextLine().toLowerCase();
		
		Tool t = factory.workWithTool(tool);
		System.out.println(t.work());


		
	}

}
