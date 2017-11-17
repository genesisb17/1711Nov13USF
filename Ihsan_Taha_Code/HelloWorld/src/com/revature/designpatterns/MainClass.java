package com.revature.designpatterns;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * SINGLETON must use the getInstance() method to
		 */
		Singleton single = Singleton.getInstance();
		
		single.hello();
		System.out.println(single.count);
		
		Singleton anotherOne = Singleton.getInstance();
		anotherOne.count++;
		System.out.println(single.count);
		
		/*
		 * FACTORY DESIGN PATTERN
		 * Here, we create an object without exposing creation logic to the client. We refer to the newly created object using a common interface.
		 */
		
		ToolFactory toolFactory = new ToolFactory();
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a tool: ");
		String tool = scan.nextLine().toLowerCase();
		
		Tool t = toolFactory.workWithTool(tool);
		System.out.println(t.work());
	}
}
