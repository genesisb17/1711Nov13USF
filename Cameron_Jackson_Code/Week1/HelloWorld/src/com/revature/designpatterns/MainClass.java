package com.revature.designpatterns;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		/*
		 * SINGLETON
		 * must use the getInstance() method to 
		 * instanctiate singleton class
		 */
		Singleton single = Singleton.getInstance();
		single.helllo();
		System.out.println(single.count);
		
		Singleton another = Singleton.getInstance();
		another.count++;
		System.out.println(single.count);
		
		/*
		 * FACTORY DESIGN PATTERN
		 * Here, we create an object witout exposing
		 * creation logic to the client. We refre to the 
		 * newly created object using a common interface
		 */
		
		ToolFactory factory = new ToolFactory();
		Scanner scan = new Scanner(System.in);
		System.out.println("choose a tool: ");
		String tool = scan.nextLine().toLowerCase();
		
		Tool t = factory.workWithTool(tool);
		System.out.println(t.work());
	}	
}
