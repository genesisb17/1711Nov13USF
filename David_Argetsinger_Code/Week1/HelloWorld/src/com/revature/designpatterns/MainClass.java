package com.revature.designpatterns;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
	
	/*
	 * somg;etpm ,ust use
	 * singleton must use getinstance() method 
	 * 
	 */
		Singleton single = Singleton.getInstance();
		single.hello();
		System.out.println(single.count);
		Singleton anotherone= Singleton.getInstance();
				anotherone.count++;

		System.out.println(single.count);
		/*
		 * factory design pattern
		 * here we create an obejct without exposing
		 * creating logic to the lient we refer to the 
		 * newly created object using common interface
		 * 
		 * 
		 */
		ToolFactory factory = new ToolFactory();
		Scanner scan = new Scanner(System.in);
				System.out.println("choose a tool");
		String tool = scan.nextLine().toLowerCase();
		Tool t = factory.workwithTool(tool);
		System.out.println(t.work());
	}
}
