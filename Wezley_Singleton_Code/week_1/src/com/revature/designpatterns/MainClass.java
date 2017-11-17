package com.revature.designpatterns;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		
		/*
		 *  Design Pattern: Singleton
		 *  	- must use getINstance() method to instantiate the singleton class
		 */
		
		Singleton single = Singleton.getInstance();
		single.hello();
		System.out.println(single.count);
		
		Singleton anotherSingle = Singleton.getInstance();
		
		// changes count for all references of the Singleton instance (they are the same object!)
		anotherSingle.count++;
		
		// prints the value of 'count' from our original singleton reference (will = 1)
		System.out.println(single.count);
		
		
		/*
		 *  Design Pattern: Factory
		 *  	- we create an object without exposing creation logic to the client. We refer to the
		 *  	  newly created object using a common interface (Tool, in this case)
		 */
		
		ToolFactory factory = new ToolFactory();
		Scanner scan = new Scanner(System.in);
		System.out.print("Choose a tool: ");
		String tool = scan.nextLine().toLowerCase();
		
		Tool t = factory.workWithTool(tool);
		System.out.println(t.work());
	}
	
}
